package com.projectswg.network.zone;

import com.google.common.util.concurrent.AbstractExecutionThreadService;

public class ZoneService extends AbstractExecutionThreadService {

    @Override
    protected void startUp() throws Exception {
        super.startUp();
    }

    @Override
    protected void run() throws Exception {

        while(isRunning()) {

           System.out.println("ZoneService is running");


        }
    }

    @Override
    protected void triggerShutdown() {
        super.triggerShutdown();
    }




}
