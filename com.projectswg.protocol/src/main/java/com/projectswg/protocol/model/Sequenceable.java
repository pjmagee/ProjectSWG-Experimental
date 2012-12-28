package com.projectswg.protocol.model;

public interface Sequenceable<T extends SOEMessage> {

    short getSequence();

}
