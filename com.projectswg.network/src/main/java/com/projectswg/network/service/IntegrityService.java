package com.projectswg.network.service;

public interface IntegrityService {

    byte[] appendCrc(byte[] data, int crcSeed);
    byte[] validate(byte[] data, int crcSeed);
}
