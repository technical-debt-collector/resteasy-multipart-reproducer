package com.example;

import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import javax.ws.rs.core.MediaType;

public class MultipartFileUpload {

    @RestForm
    @PartType(MediaType.TEXT_PLAIN)
    public FileUpload textPart;

    @RestForm
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public FileUpload anotherTextPart;

}
