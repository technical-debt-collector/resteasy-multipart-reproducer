package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class ExampleResourceTest {

    @Test
    void sendWithFilename() {
        String textPart = "Some text part for test purposes";
        String anotherTextPart = "Another one";
        given()
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .multiPart("textPart", "some_text_part.txt", textPart)
                .multiPart("anotherTextPart", "another_one.txt", anotherTextPart)
                .when()
                .post("/example")
                .then()
                .body(is("No parts were empty"))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    void sendWithFilenameByteArray() {
        String textPart = "Some text part for test purposes";
        String anotherTextPart = "Another one";
        given()
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .multiPart("textPart", "some_text_part.txt", textPart.getBytes())
                .multiPart("anotherTextPart", "another_one.txt", anotherTextPart.getBytes())
                .when()
                .post("/example")
                .then()
                .body(is("No parts were empty"))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    void sendWithoutFilename() {
        String textPart = "Some text part for test purposes";
        String anotherTextPart = "Another one";
        given()
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .multiPart("textPart", textPart)
                .multiPart("anotherTextPart", anotherTextPart)
                .when()
                .post("/example")
                .then()
                .body(is("No parts were empty"))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    void fileSendWithFilename() {
        String textPart = "Some text part for test purposes";
        String anotherTextPart = "Another one";
        given()
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .multiPart("textPart", "some_text_part.txt", textPart.getBytes())
                .multiPart("anotherTextPart", "another_one.txt", anotherTextPart.getBytes())
                .when()
                .post("/example/file")
                .then()
                .body(is("No parts were empty"))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    void fileSendWithoutFilename() {
        String textPart = "Some text part for test purposes";
        String anotherTextPart = "Another one";
        given()
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .multiPart("textPart", textPart)
                .multiPart("anotherTextPart", anotherTextPart)
                .when()
                .post("/example/file")
                .then()
                .body(is("No parts were empty"))
                .statusCode(HttpStatus.SC_OK);
    }

}