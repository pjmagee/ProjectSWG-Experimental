package com.projectswg.client;


import java.net.SocketAddress;

public interface ClientFactory {

    SWGClient create();
    SWGClient create(SocketAddress swgConnection);
}
