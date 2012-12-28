package com.projectswg.domain.module;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

import static com.google.common.base.Preconditions.checkNotNull;

public class PersistenceInitializer {

    private final PersistService persistService;

    @Inject
    public PersistenceInitializer(PersistService persistService) {
        this.persistService = checkNotNull(persistService, "persistService");
        this.persistService.start();
    }

}
