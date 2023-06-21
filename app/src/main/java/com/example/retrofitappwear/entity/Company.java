package com.example.retrofitappwear.entity;

public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    @Override
    public String toString() {
        return "Company {" +
                "name='" + name + '\'' +
                ", catchPhrase='" + catchPhrase + '\'' +
                ", bs='" + bs + '\'' +
                '}';
    }
}
