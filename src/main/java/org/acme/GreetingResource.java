package org.acme;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import io.quarkus.runtime.Startup;

@Startup
@Singleton
public class GreetingResource {

    @RestClient
    RestClientApi api;

    @Inject
    Logger log;

    @PostConstruct
    void exec() {
        api.call(200);
        try {
            api.call(400);
        } catch (Exception e) {
            log.error("This wont be in /q/metrics", e);
        }
        try {
            api.call(200, 5000);
        } catch (Exception e) {
            log.error("This will in /q/metrics", e);
        }
    }
}