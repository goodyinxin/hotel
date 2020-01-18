package com.example.hotel.utils;



public enum State implements StateCode{
        OK("ok"),FAIL("fail");

    private String code;
    State(String code) {
        this.code = code;
    }

    @Override
    public String INFO() {
        return this.name().toLowerCase();
    }
}


