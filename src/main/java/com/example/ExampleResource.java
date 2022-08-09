package com.example;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.reactive.MultipartForm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/example")
public class ExampleResource {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    @Blocking
    public Uni<Response> exampleMethod(@MultipartForm MultipartUpload multipartUpload) {
        if (multipartUpload.textPart == null && multipartUpload.anotherTextPart == null)
            return Uni.createFrom().item(Response.serverError().entity("Both parts in the multipart are null").build());
        if (multipartUpload.textPart == null)
            return Uni.createFrom().item(Response.serverError().entity("The textPart in the multipart is null").build());
        if (multipartUpload.anotherTextPart == null)
            return Uni.createFrom().item(Response.serverError().entity("The anotherTextPart in the multipart is null").build());

        return Uni.createFrom().item(Response.ok("No parts were empty").build());
    }

    @Path("/file")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    @Blocking
    public Uni<Response> exampleFileMethod(@MultipartForm MultipartFileUpload multipartUpload) {
        if (multipartUpload.textPart == null && multipartUpload.anotherTextPart == null)
            return Uni.createFrom().item(Response.serverError().entity("Both parts in the multipart are null").build());
        if (multipartUpload.textPart == null)
            return Uni.createFrom().item(Response.serverError().entity("The textPart in the multipart is null").build());
        if (multipartUpload.anotherTextPart == null)
            return Uni.createFrom().item(Response.serverError().entity("The anotherTextPart in the multipart is null").build());

        return Uni.createFrom().item(Response.ok("No parts were empty").build());
    }
}