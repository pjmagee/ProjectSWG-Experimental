package com.projectswg.protocol.swg.baseline.PLAY;


import com.projectswg.protocol.swg.baseline.AbstractBaselineObject;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class PLAY6 extends AbstractBaselineObject {

    @Override
    public byte[] serialize() {

        ByteBuffer result = ByteBuffer.allocate(1024).order(ByteOrder.LITTLE_ENDIAN);

        result.putShort((short)0x11);
        result.putInt((short)0x8A);
        result.put(getAsciiString("string_id_table"));
        result.putLong(0);
        result.putLong(0);
        result.putLong(0);
        result.putLong(0);
        result.putLong(0);
        result.putLong(0);
        result.putLong(0);
        result.putShort((short)0);

        int size = result.position();

        return ByteBuffer.allocate(size).put(result.array(), 0, size).array();
    }
}
