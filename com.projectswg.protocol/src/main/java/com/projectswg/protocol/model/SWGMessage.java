package com.projectswg.protocol.model;


import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;


public abstract class SWGMessage extends SOEMessage {

    protected short operandCount;
    protected int opcode;

    protected SWGMessage(byte[] data) {
        super(data);
        opcode = ByteBuffer.wrap(data).getInt(2);
    }

    public abstract byte[] serialize();

    protected String getAsciiString(ByteBuffer buffer) {
        return getString(buffer, "US-ASCII");
    }

    protected String getUnicodeString(ByteBuffer buffer) {
        return getString(buffer, "UTF-16LE");
    }

    protected byte[] getAsciiString(String string) {
        return getString(string, "US-ASCII");
    }

    protected byte[] getUnicodeString(String string) {
        return getString(string, "UTF-16LE");
    }


    private String getString(ByteBuffer buffer, String charFormat) {

        String result;

        int length;

        if (charFormat == "UTF-16LE")    {
            length = buffer.order(ByteOrder.LITTLE_ENDIAN).getInt();
        }
        else   {
            length = buffer.order(ByteOrder.LITTLE_ENDIAN).getShort();
        }

        int bufferPosition = buffer.position();

        try {
            result = new String(buffer.array(), bufferPosition, length, charFormat);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }

        buffer.position(bufferPosition + length);

        return result;
    }

    private byte[] getString(String string, String charFormat) {

        ByteBuffer result;
        int length = 2 + string.length();

        if (charFormat == "UTF-16LE") {
            result = ByteBuffer.allocate(length * 2).order(ByteOrder.LITTLE_ENDIAN);
            result.putInt(string.length());
        } else {
            result = ByteBuffer.allocate(length).order(ByteOrder.LITTLE_ENDIAN);
            result.putShort((short)string.length());
        }

        try {
            result.put(string.getBytes(charFormat));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new byte[] { };
        }
        return result.array();
    }

}
