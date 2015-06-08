package com.test.app.hello;

import com.sun.net.httpserver.HttpServer;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.junit.Assert.assertEquals;


/**
 * Created by zc on 2015/6/8.
 */
public class HelloResTest {

    @Test
    public void getHello(){
        Client client =  ClientBuilder.newClient();
        WebTarget resource = client.target("http://localhost:8080/hello-world");

        // Get XML response as a Customer
        String str = resource.request(MediaType.APPLICATION_XML)
                .get(String.class);
        System.out.println(str);

        // Get JSON response as a Custom2er
        String str2 = resource.request(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println(str2);
    }

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        Client c = ClientBuilder.newClient();
        target = c.target("http://localhost:8080");
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("hello-world").path("getHello")
                .request().get(String.class);
        assertEquals("Hello world!", responseMsg);
    }
}
