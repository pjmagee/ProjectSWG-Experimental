package com.projectswg.domain.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Named;
import com.google.inject.persist.finder.Finder;
import com.projectswg.domain.entity.PlayerCharacter;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class PlayerCharacterDaoImpl extends GenericDao<PlayerCharacter> implements PlayerCharacterDao  {

    @Inject
    public PlayerCharacterDaoImpl(TypeLiteral<PlayerCharacter> type, Provider<EntityManager> emp) {
        super(type, emp);
    }


    @Override
    @Finder(query = "from PlayerCharacter where account_id = :id")
    public List<PlayerCharacter> findAllByAccountId(@Named("accountId")Long id) {

        return Collections.emptyList();

    }
}
