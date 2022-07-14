package com.myhome.util;

import com.android.volley.VolleyError;
import com.myhome.service.api.constants.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseEntity<T> {

    private HttpStatus status;
    private T object;
    private VolleyError error;

    public ResponseEntity() {}

    public ResponseEntity(HttpStatus status) {
        this.status = status;
    }

    public ResponseEntity(HttpStatus status, VolleyError error) {
        this.status = status;
        this.error = error;
    }

    public ResponseEntity(HttpStatus status, T object) {
        this.status = status;
        this.object = object;
    }
}
