package com.projectswg.domain.dao;

import com.projectswg.domain.entity.Account;


public interface AccountDao extends Dao<Account> {

    Account findAccountByCharacterId(Long id);

}
