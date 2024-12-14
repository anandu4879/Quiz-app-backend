package com.anandu.quziApp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.management.ConstructorParameters;
@RequiredArgsConstructor
public class Response {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    private Integer id;

    public Response(Integer id, String response) {
        this.id = id;
        this.response = response;
    }

    private  String response;
}
