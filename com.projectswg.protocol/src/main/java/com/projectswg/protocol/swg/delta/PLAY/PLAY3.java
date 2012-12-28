package com.projectswg.protocol.swg.delta.PLAY;

import com.projectswg.protocol.swg.delta.AbstractDeltaObject;
import com.projectswg.protocol.swg.delta.Profession;

public class PLAY3 extends AbstractDeltaObject {

    private short updateCounter;
    private short updateType;
    private Profession profession;

    public PLAY3(short updateCounter, short updateType, Profession profession){
        this.updateCounter = updateCounter;
        this.updateType = updateType;
        this.profession = profession;
    }


    @Override
    public byte[] serialize() {
        return new byte[0];  //To change body of implemented methods use File | Settings | File Templates.
    }
}
