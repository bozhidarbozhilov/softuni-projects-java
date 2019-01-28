package com.company.Implementations;

public class HttpCookie {
    private String key;
    private String value;

    public HttpCookie(String key, String value) {
        this.setKey(key);
        this.setValue(value);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
