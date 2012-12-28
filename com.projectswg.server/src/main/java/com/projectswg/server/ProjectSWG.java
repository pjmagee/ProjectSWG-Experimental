package com.projectswg.server;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.PersistService;
import com.projectswg.client.ClientModule;
import com.projectswg.domain.module.PersistenceModule;
import com.projectswg.network.NetworkModule;
import com.projectswg.network.login.LoginService;
import com.projectswg.network.zone.ZoneService;
import com.projectswg.protocol.ProtocolModule;

public class ProjectSWG {

    public static void main(String[] args) {

        // Composition Root - Closest point to the entry of the application
        // Wiring  of dependencies will take place here with Guice Inject


        Module[] modules = new Module[]
                {
                        new NetworkModule(), // Networking layer
                        new ClientModule(), // Client layer
                        new ProtocolModule(), // Protocol layer
                        new PersistenceModule("projectswg") // Persistence Layer
                };

        Injector injector = Guice.createInjector(modules);

        PersistService persistService = injector.getInstance(PersistService.class);
        persistService.start();

        LoginService loginService = injector.getInstance(LoginService.class);
        loginService.start();

        ZoneService zoneService = injector.getInstance(ZoneService.class);
        zoneService.start();
    }

}
