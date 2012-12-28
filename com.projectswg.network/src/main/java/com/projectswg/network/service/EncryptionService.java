package com.projectswg.network.service;

public interface EncryptionService {

    byte[] encryt(byte[] data, int crcSeed);
    byte[] decrypt(byte[] data, int crcSeed);

}
