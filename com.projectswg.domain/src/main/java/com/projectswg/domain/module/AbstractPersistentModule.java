package com.projectswg.domain.module;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.ScopedBindingBuilder;
import com.google.inject.util.Types;

import com.projectswg.domain.dao.Dao;
import com.projectswg.domain.dao.GenericDao;
import com.projectswg.domain.entity.Bean;

import java.lang.reflect.Type;

import static com.google.common.base.Preconditions.checkArgument;

public abstract class AbstractPersistentModule extends AbstractModule {

    /**
     * Creates a implementation of a {@link com.projectswg.domain.dao.GenericDao} for the given type and
     * made it managed by guice.
     *
     * @param type
     * bean type to let inject a genericdao.
     * @param <T>
     */
    protected <T extends Bean> ScopedBindingBuilder bindGenericDaoFor(Class<T> type) {
        checkArgument(type != null, "Type must not be null.");
        return new DaoTypeLiteralHelper<>(type).bind();
    }

    private class DaoTypeLiteralHelper<T extends Bean> {

        private Class<T> type;

        private DaoTypeLiteralHelper(Class<T> type) {
            this.type = type;
        }

        private ScopedBindingBuilder bind() {
            return AbstractPersistentModule.this.bind(dao()).to(genericDao());
        }

        @SuppressWarnings({ "hiding", "unchecked" })
        private <T> TypeLiteral<T> dao() {
            return (TypeLiteral<T>) TypeLiteral.get(Types.newParameterizedType(
                    Dao.class, type));
        }

        @SuppressWarnings({ "hiding", "unchecked" })
        private <T extends Bean> TypeLiteral<T> genericDao() {
            return (TypeLiteral<T>) TypeLiteral.get(Types.newParameterizedType(
                    GenericDao.class, type, getKey()));
        }

        private Type getKey() {
            return Key.get(type).getClass();
        }
    }
}