package com.myhome.other;

public enum API {

    // REPLACE BY SERVER IP
    URL_BASE("http://192.168.8.92:8080/"),

    URL_ACCOUNT("/account"),
    URL_LOGIN("/login"),
    URL_REGISTER("/register"),
    URL_FORGOTTEN_PW("/forgotten"),

    URL_MEMBER("/member"),
    URL_DELETE_MEMBER(""),

    // General URLs
    URL_FETCH_ALL("get-all"),
    URL_INSERT("/insert"),
    URL_DELETE("/delete"),
    URL_UPDATE("/update"),

    FIELD_EMAIL("e-mail"),
    FIELD_PASSWORD("password"),
    FIELD_TOKEN("token"),
    FIELD_NEW_EMAIL("new-email"),
    FIELD_NEW_PASSWORD("new-password"),
    FIELD_ACCOUNT_ID("account-id");

    private final String s;

    API(String s) {
        this.s = s;
    }

    public String value() {
        return s;
    }
}
