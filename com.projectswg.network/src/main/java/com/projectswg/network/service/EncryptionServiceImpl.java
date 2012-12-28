package com.projectswg.network.service;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class EncryptionServiceImpl implements EncryptionService {

    @Override
    public byte[] encryt(byte[] data, int crcSeed) {
        return encryptWithCrc(data, crcSeed, true);
    }

    @Override
    public byte[] decrypt(byte[] data, int crcSeed) {
        return encryptWithCrc(data, crcSeed, false);
    }

    private byte[] encryptWithCrc(byte[] data, int crcSeed, boolean out) {

        int startingIndex = 2;

        if (data.length < 4)
            return new byte[] { };

        if (data[0] > 0x00 && data[0] < 0x10)
            startingIndex = 1;

        ByteBuffer sourceByteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        ByteBuffer resultByteBuffer = ByteBuffer.allocate(data.length).order(ByteOrder.LITTLE_ENDIAN);

        try {
            resultByteBuffer.put(data[0]);
            if (startingIndex > 1)
                resultByteBuffer.put(data[1]);

            if (data.length < 6)
                for (int i = startingIndex; i < data.length; i++)
                    resultByteBuffer.put((byte)(data[i] ^ crcSeed));
            else {

                resultByteBuffer.putInt(sourceByteBuffer.getInt(startingIndex) ^ crcSeed);

                int i = startingIndex + 4;

                for (int j = startingIndex; i <= data.length - 4; i += 4, j += 4)
                    resultByteBuffer.putInt(sourceByteBuffer.getInt(i) ^ (out ? resultByteBuffer.getInt(j) : sourceByteBuffer.getInt(j)));
                for (int j = i - 4; i < data.length; i++)
                    resultByteBuffer.put((byte) (data[i] ^ (out ? resultByteBuffer.get(j) : sourceByteBuffer.get(j))));

            }

            return resultByteBuffer.array();

        } catch (ArrayIndexOutOfBoundsException e) {

            return new byte[]{};
        }
    }

}
