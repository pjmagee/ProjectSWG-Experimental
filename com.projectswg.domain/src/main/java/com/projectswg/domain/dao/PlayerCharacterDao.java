package com.projectswg.domain.dao;

import com.projectswg.domain.entity.PlayerCharacter;

import java.util.List;

public interface PlayerCharacterDao extends Dao<PlayerCharacter> {

    public List<PlayerCharacter> findAllByAccountId(Long id);

}
