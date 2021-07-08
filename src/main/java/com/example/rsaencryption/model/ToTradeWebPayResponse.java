package com.example.rsaencryption.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ToTradeWebPayResponse implements Serializable {
    private String toPayUrl;
}
