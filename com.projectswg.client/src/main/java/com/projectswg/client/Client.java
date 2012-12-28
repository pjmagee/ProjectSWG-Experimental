package com.projectswg.client;

import com.projectswg.protocol.model.SWGMessage;
import com.projectswg.protocol.model.Sequenceable;
import java.net.SocketAddress;
import java.util.Vector;

public final class Client implements SWGClient {

    protected long accountId;
    protected String username;
    protected String password;
    protected boolean ready;
    protected byte[] sessionKey;

    protected int connectionId;
    protected int crc;

    protected SocketAddress address;
    protected long packetsSent;
    protected long packetsReceived;

    protected short serverSequence;
    protected short lastAcknowledgedSequence;
    protected short nextSequence;

    protected Vector<SWGMessage> messageQueue;
    protected Vector<Sequenceable> unacknowledgedMessages;

    @Override
    public long getAccountId() {
        return accountId;
    }

    @Override
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isReady() {
        return ready;
    }

    @Override
    public void setReady(boolean ready) {
        this.ready = ready;
    }

    @Override
    public byte[] getSessionKey() {
        return sessionKey;
    }

    @Override
    public void setSessionKey(byte[] sessionKey) {
        this.sessionKey = sessionKey;
    }

    @Override
    public int getConnectionId() {
        return connectionId;
    }

    @Override
    public void setConnectionId(int connectionId) {
        this.connectionId = connectionId;
    }

    @Override
    public int getCrc() {
        return crc;
    }

    @Override
    public void setCrc(int crc) {
        this.crc = crc;
    }

    @Override
    public long getPacketsSent() {
        return packetsSent;
    }

    @Override
    public void setPacketsSent(long packetsSent) {
        this.packetsSent = packetsSent;
    }

    @Override
    public short getNextSequence() {
        return nextSequence;
    }

    @Override
    public void setNextSequence(short nextSequence) {
        this.nextSequence = nextSequence;
    }

    @Override
    public SocketAddress getAddress() {
        return address;
    }

    @Override
    public void setAddress(SocketAddress address) {
        this.address = address;
    }

    @Override
    public long getPacketsReceived() {
        return packetsReceived;
    }

    @Override
    public void setPacketsReceived(long packetsReceived) {
        this.packetsReceived = packetsReceived;
    }

    @Override
    public short getServerSequence() {
        return serverSequence;
    }

    @Override
    public void setServerSequence(short serverSequence) {
        this.serverSequence = serverSequence;
    }

    @Override
    public short getLastAcknowledgedSequence() {
        return lastAcknowledgedSequence;
    }

    @Override
    public void setLastAcknowledgedSequence(short lastAcknowledgedSequence) {
        this.lastAcknowledgedSequence = lastAcknowledgedSequence;
    }

    @Override
    public Vector<SWGMessage> getMessageQueue() {
        return messageQueue;
    }

    @Override
    public void setMessageQueue(Vector<SWGMessage> messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public Vector<Sequenceable> getUnacknowledgedMessages() {
        return unacknowledgedMessages;
    }

    @Override
    public void setUnacknowledgedMessages(Vector<Sequenceable> unacknowledgedMessages) {
        this.unacknowledgedMessages = unacknowledgedMessages;
    }
}
