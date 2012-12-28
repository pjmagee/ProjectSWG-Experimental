package com.projectswg.protocol.model;

public abstract class SOEMessage {

    protected final byte[] data;

    protected SOEMessage(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data == null ? new byte[] {} : data.clone();
    }

}
