package com.projectswg.network.service;


import com.projectswg.client.SWGConnection;
import com.projectswg.protocol.model.SOEMessage;

public interface PackagingService {

    byte[][] assemble(SOEMessage soeMessage, SWGConnection swgConnection);

    byte[] disassemble(byte[] data, int crcSeed);

}
