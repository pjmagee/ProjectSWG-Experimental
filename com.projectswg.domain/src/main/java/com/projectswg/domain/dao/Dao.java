package com.projectswg.domain.dao;

import com.projectswg.domain.entity.Bean;

import java.util.List;

public interface Dao<T extends Bean> {

    public void save(T t);
    public List<T> findAll();
    public T find(Long id);
    public void remove(T t);

}
