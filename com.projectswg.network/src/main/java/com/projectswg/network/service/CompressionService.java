package com.projectswg.network.service;

public interface CompressionService {

    public byte[] compress(byte[] data);

    public byte[] decompress(byte[] data);

}
