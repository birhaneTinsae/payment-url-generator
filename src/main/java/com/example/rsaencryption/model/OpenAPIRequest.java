package com.example.rsaencryption.model;

import lombok.Data;

import java.io.Serializable;

//@Data
public class OpenAPIRequest implements Serializable {
    private String appid;
    private String sign;
    private String ussd;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getUssd() {
        return ussd;
    }

    public void setUssd(String ussd) {
        this.ussd = ussd;
    }
}
