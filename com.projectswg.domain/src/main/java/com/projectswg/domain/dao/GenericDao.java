package com.projectswg.domain.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.persist.Transactional;
import com.projectswg.domain.entity.Bean;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Specific Dao should extend this class.
 * @param <T>
 *
 * @see <a href="http://code.google.com/p/google-guice/wiki/Transactions">Transactional Documentation</a>
 * found on the Google Guice Wiki
 */
public class GenericDao<T extends Bean> implements Dao<T> {

    private final Provider<EntityManager> emp;
    private final Class<T> clazz;

    @Inject
    @SuppressWarnings("unchecked")
    protected GenericDao(TypeLiteral<T> type, Provider<EntityManager> emp) {
        checkArgument(type != null, "type must not be null.");
        this.clazz = (Class<T>) type.getRawType();
        this.emp = emp;
    }

    protected EntityManager em() {
        return emp.get();
    }

    @Transactional
    public void save(T t) {
        if (t.getId() != null) {
            t = em().merge(t);
        } else {
            em().persist(t);
        }
    }

    public List<T> findAll() {
        TypedQuery<T> q = em().createQuery("select e from " + clazz.getSimpleName() + " e", clazz);
        return q.getResultList();
    }

    public T find(Long id) {
        return em().getReference(clazz, id);
    }

    @Transactional
    public void remove(T t) {
        em().remove(t);
    }

}
