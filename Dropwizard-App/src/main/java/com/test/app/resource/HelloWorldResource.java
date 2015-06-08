package com.test.app.resource;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.test.app.core.Saying;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zc on 2015/6/8.
 */

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    private static final String CLICHED_MESSAGES = "Hello world!";

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;


    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }

    @POST
    @Timed
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Saying sayHelloPost(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }

    @GET
    @Path("/getHello")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello(){
        return CLICHED_MESSAGES;
    }
}
