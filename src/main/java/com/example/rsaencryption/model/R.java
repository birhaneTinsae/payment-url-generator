package com.example.rsaencryption.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class R<T> implements Serializable {
    private int code;
    private T data;
    private String message;
}
