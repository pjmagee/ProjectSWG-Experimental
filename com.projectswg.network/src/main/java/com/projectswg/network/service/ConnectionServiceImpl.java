package com.projectswg.network.service;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.projectswg.protocol.model.SWGMessage;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Vector;

import static com.google.common.base.Preconditions.checkNotNull;

public final class ConnectionServiceImpl extends AbstractExecutionThreadService implements ConnectionService  {

    private DatagramSocket socket;
    private DatagramPacket packet;
    private PackagingService packagingService;
    private Map<String, Vector<SWGMessage>> queue;

    public ConnectionServiceImpl(DatagramSocket socket, DatagramPacket packet, PackagingService packagingService) {
        this.socket = checkNotNull(socket, "socket");
        this.packet = checkNotNull(packet, "packet");
        this.packagingService = checkNotNull(packagingService, "packagingService");
    }

    @Override
    protected void run() throws Exception {

       while(isRunning()) {

            socket.receive(packet);

            int length = packet.getLength();

            byte[] data = ByteBuffer.allocate(length).put(packet.getData(), 0, length).array();


        }

    }
}
