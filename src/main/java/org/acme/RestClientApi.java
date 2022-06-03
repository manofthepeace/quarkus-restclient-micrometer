package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestQuery;

@RegisterRestClient(configKey = "rest-api")
public interface RestClientApi {

    @GET
    @Path("/{statusCode}")
    public void call(@RestPath int statusCode);

    @GET
    @Path("/{statusCode}")
    public void call(int statusCode, @RestQuery int sleep);

}
