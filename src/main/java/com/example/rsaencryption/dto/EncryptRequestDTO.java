package com.example.rsaencryption.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EncryptRequestDTO implements Serializable {
    private String receiveName;
    private String outTradeNo;
    private String shortCode;
    private String subject;
    private String totalAmount;
    private String notifyUrl;
    private String returnUrl;
    private String appid;
    private String timeoutExpress;
    private String nonce;
    private String timestamp;
}
