package com.projectswg.domain.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.projectswg.domain.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * The Account Dao handles all data for the Account Entity
 */
public class AccountDaoImpl extends GenericDao<Account> implements AccountDao {

    @Inject
    public AccountDaoImpl(TypeLiteral<Account> type, Provider<EntityManager> emp) {
        super(type, emp);
    }

    @Override
    public Account findAccountByCharacterId(Long id) {

        String s = "select character.account " +
                   "from PlayerCharacter as character " +
                   "where character.id = " + id;

        TypedQuery<Account> query = em().createQuery(s, Account.class);



        return query.getSingleResult();


    }
}
