package com.projectswg.protocol.swg.delta;

public enum Profession {

    SPY("spy_1a"),
    SMUGGLER("smuggler_1a"),
    OFFICER("officer_1a"),
    JEDI("force_sensative_1a"),
    COMMANDO("commando_1a"),
    MEDIC("medic_1a"),
    BOUNTYHUNTER("bounty_hunter_1a");

    private String value;

    private Profession(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }



}
