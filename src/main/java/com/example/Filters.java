package com.example;

import io.quarkus.logging.Log;
import org.jboss.resteasy.reactive.server.ServerRequestFilter;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Filters {

    @ServerRequestFilter
    public void debugMultipartHeaders(ContainerRequestContext containerRequestContext) {
        try {
            InputStream is = containerRequestContext.getEntityStream();
            byte[] data = is.readAllBytes();
            String body = Arrays.stream(new String(data, StandardCharsets.UTF_8)
                            .split("\n"))
                    .filter(line -> line.startsWith("Content-"))
                    .collect(Collectors.joining("\n"));
            Log.info("The body was the following:\n" + body);
            containerRequestContext.setEntityStream(new ByteArrayInputStream(data));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
