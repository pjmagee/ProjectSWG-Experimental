package com.projectswg.network.login;

import static com.google.common.base.Preconditions.checkNotNull;
import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.inject.Inject;
import com.projectswg.client.*;
import com.projectswg.domain.dao.AccountDao;
import com.projectswg.network.service.PackagingService;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginService extends AbstractExecutionThreadService {

    private DatagramSocket socket; // Server socket
    private DatagramPacket packet; // Packet received
    private Map<SocketAddress, SWGClient> connections; // Client connections
    private AccountDao accountDao;

    private PackagingService packagingService;
    private ClientFactory clientFactory;

    @Inject
    public LoginService(PackagingService packagingService, ClientFactory clientFactory, AccountDao accountDao) {
        this.accountDao = checkNotNull(accountDao, "accountDao");
        this.packagingService = checkNotNull(packagingService, "packagingService");
        this.clientFactory = checkNotNull(clientFactory, "clientFactory");
    }


    @Override
    protected void startUp() throws Exception {
        socket = new DatagramSocket(4444);
        connections = new ConcurrentHashMap<SocketAddress, SWGClient>();
    }

    @Override
    protected void run() throws Exception {
        while(isRunning()) {

            // PACKET RECEIVED

            socket.receive(packet);
            int length = packet.getLength();
            byte[] data = ByteBuffer.allocate(length).put(packet.getData(), 0, length).array();
            SocketAddress address = packet.getSocketAddress();

            // ALLOCATE CLIENT
            SWGClient client = (!connections.containsKey(address))
                    ? clientFactory.create(address) :
                      connections.get(address);

            data = packagingService.disassemble(data, client.getCrc());

            if(data.length == 1) {
                //TODO: Queue logout packet
                //TODO:  Disconnect client
            }
            else if(data.length == 0) {

            }
            else {

                //TODO: Create SWG Message from data


            }



        }
    }

    @Override
    protected void triggerShutdown() {
        super.triggerShutdown();
    }
}
