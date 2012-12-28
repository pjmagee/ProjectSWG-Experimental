package com.projectswg.domain.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "CHARACTERS" )
public final class PlayerCharacter extends Bean {

    private String firstName;
    private String lastName;
    private Date created;
    private Account account;

    public PlayerCharacter() {

    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param created
     */
    public PlayerCharacter(String firstName, String lastName, Date created) {
        this(firstName, lastName);
        this.created = created;
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param account
     * @param created
     */
    public PlayerCharacter(String firstName, String lastName, Account account, Date created) {
        this(firstName, lastName);
        this.account = account;
        this.created = created;
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param account
     */
    public PlayerCharacter(String firstName, String lastName, Account account) {
        this(firstName, lastName);
        this.account = account;
    }

    /**
     *
     * @param firstName
     * @param lastName
     */
    public PlayerCharacter(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", nullable = false)
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public String toString() {

        return String.format("id: %s, account id: %s, first name: %s, last name: %s, created: %s",
                this.getId(), account.getId(), firstName, lastName, created);

    }


}
