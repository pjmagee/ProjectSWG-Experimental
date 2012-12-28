package com.projectswg.domain.module;

import com.google.inject.persist.jpa.JpaPersistModule;
import com.projectswg.domain.dao.AccountDao;
import com.projectswg.domain.dao.AccountDaoImpl;
import com.projectswg.domain.dao.PlayerCharacterDao;
import com.projectswg.domain.dao.PlayerCharacterDaoImpl;

public class PersistenceModule extends AbstractPersistentModule {

    private final String pu;

    public PersistenceModule(String pu) {
        this.pu = pu;
    }


    @Override
    protected void configure() {

        install(new JpaPersistModule(pu));

        // forcing it as a eager singleton, so it will start automagically with the app..
        bind(PersistenceInitializer.class).asEagerSingleton();

        bind(PlayerCharacterDao.class).to(PlayerCharacterDaoImpl.class);
        bind(AccountDao.class).to(AccountDaoImpl.class);
    }
}
