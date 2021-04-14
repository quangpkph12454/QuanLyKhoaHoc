package com.example.assigment.model;

public class Lists {
    private String maMon, monHoc;

    @Override
    public String toString() {
        return maMon ;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

    public Lists() {
    }

    public Lists(String maMon, String monHoc) {
        this.maMon = maMon;
        this.monHoc = monHoc;
    }
}
