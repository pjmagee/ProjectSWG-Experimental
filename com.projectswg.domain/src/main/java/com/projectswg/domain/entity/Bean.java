package com.projectswg.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class Bean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Long version;

    public Bean(Long id, Long version) {
        this.id = id;
        this.version = version;
    }

    public Bean() {
    }

    protected Bean(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}