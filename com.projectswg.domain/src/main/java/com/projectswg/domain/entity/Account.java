package com.projectswg.domain.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table( name = "ACCOUNTS" )
public final class Account extends Bean {

    private String username;
    private String password;
    private Collection<PlayerCharacter> playerCharacters;
    private Date created;
    private Boolean disabled;

    /**
     * Hibernate Constructor
     */
    public Account(){

    }

    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Account(String username, String password, Date created) {
        this(username, password);
        this.created = created;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL, }, mappedBy = "account")
    public Collection<PlayerCharacter> getPlayerCharacters() {
        return playerCharacters;
    }

    public void setPlayerCharacters(Collection<PlayerCharacter> playerCharacters) {
        this.playerCharacters = playerCharacters;
    }

    public Boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }


    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {

        return String.format("id: %s, user: %s, pass: %s, created: %s, disabled: %s",
                this.getId(), username, password, created, disabled);


    }
}
