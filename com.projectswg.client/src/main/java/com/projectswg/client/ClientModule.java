package com.projectswg.client;

import com.google.inject.AbstractModule;

public class ClientModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(SWGClient.class).to(Client.class);
        bind(ClientFactory.class).to(ClientFactoryImpl.class);


    }
}
