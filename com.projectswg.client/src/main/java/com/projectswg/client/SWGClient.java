package com.projectswg.client;

import com.projectswg.protocol.model.SWGMessage;
import com.projectswg.protocol.model.Sequenceable;

import java.net.SocketAddress;
import java.util.Vector;

public interface SWGClient {

    long getAccountId();

    void setAccountId(long accountId);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    boolean isReady();

    void setReady(boolean ready);

    byte[] getSessionKey();

    void setSessionKey(byte[] sessionKey);

    int getConnectionId();

    void setConnectionId(int connectionId);

    int getCrc();

    void setCrc(int crc);

    long getPacketsSent();

    void setPacketsSent(long packetsSent);

    short getNextSequence();

    void setNextSequence(short nextSequence);

    SocketAddress getAddress();

    void setAddress(SocketAddress address);

    long getPacketsReceived();

    void setPacketsReceived(long packetsReceived);

    short getServerSequence();

    void setServerSequence(short serverSequence);

    short getLastAcknowledgedSequence();

    void setLastAcknowledgedSequence(short lastAcknowledgedSequence);

    Vector<SWGMessage> getMessageQueue();

    void setMessageQueue(Vector<SWGMessage> messageQueue);

    Vector<Sequenceable> getUnacknowledgedMessages();

    void setUnacknowledgedMessages(Vector<Sequenceable> unacknowledgedMessages);
}
