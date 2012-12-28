package com.projectswg.network;

import com.google.inject.AbstractModule;
import com.projectswg.network.service.*;

public class NetworkModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(CompressionService.class).to(CompressionServiceImpl.class);
        bind(IntegrityService.class).to(IntegrityServiceImpl.class);
        bind(PackagingService.class).to(PackagingServiceImpl.class);
        bind(ConnectionService.class).to(ConnectionServiceImpl.class);

    }
}
