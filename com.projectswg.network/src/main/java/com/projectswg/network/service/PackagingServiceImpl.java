package com.projectswg.network.service;

import com.google.inject.Inject;
import com.projectswg.client.SWGConnection;
import com.projectswg.protocol.model.SOEMessage;

import static com.google.common.base.Preconditions.checkNotNull;

public final class PackagingServiceImpl implements PackagingService {

    private final CompressionService compressionService;
    private final EncryptionService encryptionService;
    private final IntegrityService integrityService;

    @Inject
    public PackagingServiceImpl(CompressionService compressionService, EncryptionService encryptionService, IntegrityService integrityService) {
        this.compressionService = checkNotNull(compressionService, "compressionService");
        this.encryptionService = checkNotNull(encryptionService, "encryptionService");
        this.integrityService = checkNotNull(integrityService, "integrityService");;
    }


    @Override
    public byte[][] assemble(SOEMessage soeMessage, SWGConnection swgConnection) {
        return new byte[0][];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public byte[] disassemble(byte[] data, int crcSeed) {

        return crcSeed == 0 ? data :
                compressionService.decompress(
                        encryptionService.decrypt(integrityService.validate(data, crcSeed), crcSeed));

    }
}
