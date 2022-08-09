package com.example;

import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;

import javax.ws.rs.core.MediaType;

public class MultipartUpload {

    @RestForm
    @PartType(MediaType.TEXT_PLAIN)
    public String textPart;

    @RestForm
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public String anotherTextPart;

}
