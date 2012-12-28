package com.projectswg.protocol.swg.baseline.CREO;

import com.projectswg.protocol.swg.baseline.AbstractBaselineObject;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class CREO3 extends AbstractBaselineObject {

    private String str1, str2, str3;
    private byte[] customizationData;

    public CREO3(String str1, String str2, String str3, byte[] customizationData) {
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
        this.customizationData = customizationData;
    }

    @Override
    public byte[] serialize() {

        ByteBuffer result = ByteBuffer.allocate(1024).order(ByteOrder.LITTLE_ENDIAN);

        result.putShort((short)0x13); // 19 object count
        result.order(ByteOrder.BIG_ENDIAN).putInt(0x803F).order(ByteOrder.LITTLE_ENDIAN);  // scale

        result.put(getAsciiString(str1)); // 'species'
        result.putInt(0); // 0

        result.put(getAsciiString(str2)); // 'human'
        result.put(getUnicodeString(str3)); // entity name

        result.putInt(0x000F4240);	// unk

        result.putLong(0);	// 32

        result.putShort((short)customizationData.length);
        result.put(customizationData);
        result.putInt(1); // unknowns
        result.putInt(0);
        result.putInt(0);
        result.putInt(0x80);
        result.putInt(0);
        result.putInt(0);
        result.putInt(0x3A98);

        result.put((byte)0x01); // unknown
        result.order(ByteOrder.BIG_ENDIAN).putShort((short)0x01).order(ByteOrder.LITTLE_ENDIAN); // posture

        result.putLong(0);	// target objectId
        result.putInt(0x3F74517A); // height
        result.putInt(0); // fatigue
        result.putLong(0); // state

        int size = result.position();
        return ByteBuffer.allocate(size).put(result.array(), 0, size).array();
    }

}
