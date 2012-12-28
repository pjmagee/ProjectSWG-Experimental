package com.projectswg.protocol.swg.baseline.PLAY;

import com.projectswg.protocol.swg.baseline.AbstractBaselineObject;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class PLAY9 extends AbstractBaselineObject {

    @Override
    public byte[] serialize() {

        ByteBuffer result = ByteBuffer.allocate(1024).order(ByteOrder.LITTLE_ENDIAN);

        result.putShort((short)0x1f);
        result.putInt(0);
        result.putInt(0);
        result.putInt(0);
        result.putInt(0);

        result.putInt(3);
        result.putInt(3);

        result.put((byte)0);
        result.putLong(0x60AB05D830254293L);
        result.putInt(1);

        result.put((byte)0);
        result.putLong(0x6C7509084BB23CAEL);
        result.putInt(1);

        result.put((byte)0);
        result.putLong(0x757A3F1783AADF10L);
        result.putInt(1);

        result.putInt(0);
        result.putInt(0);
        result.putInt(8);
        result.putInt(0);

        result.putInt(10);	// Friend count
        result.putInt(33);

        result.put(getAsciiString("atima"));
        result.put(getAsciiString("brokovo"));
        result.put(getAsciiString("daymian"));
        result.put(getAsciiString("dow-jones"));
        result.put(getAsciiString("eclipse.pandoren"));
        result.put(getAsciiString("eclipse.rabivesk"));
        result.put(getAsciiString("kenpachie"));
        result.put(getAsciiString("melony"));
        result.put(getAsciiString("omatchi'"));
        result.put(getAsciiString("sobli"));

        result.putInt(0);
        result.putInt(3);
        result.putInt(1);
        result.putInt(0);
        result.putInt(100);
        result.putInt(0);

        result.putInt(100);
        result.putInt(0);
        result.putInt(100);
        result.putInt(0);
        result.putInt(0);

        result.putInt(0);
        result.putInt(3);
        result.putInt(0);
        result.putInt(0);

        result.putInt(0);
        result.putInt(0);
        result.putInt(0);
        result.putInt(0);
        result.putInt(0);

        result.putInt(0);
        result.putInt(2);
        result.putInt(0);
        result.putInt(0);
        result.putInt(0);

        result.putInt(0);
        result.putInt(0);
        result.putInt(0);
        result.putInt(0);
        result.putInt(0);

        result.putInt(0);
        result.putShort((short)0);

        int size = result.position();
        return ByteBuffer.allocate(size).put(result.array(), 0, size).array();

    }
}
