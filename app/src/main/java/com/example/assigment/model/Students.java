package com.example.assigment.model;

public class Students {
    private String mamon,monhoc;

    public String getMaMon() {
        return mamon;
    }

    public void setMaMon(String mamon) {
        this.mamon = mamon;
    }

    public String getMonHoc() {
        return monhoc;
    }

    public void setMonHoc(String monhoc) {
        this.monhoc = monhoc;
    }

    public Students() {
    }

    public Students(String mamon, String monhoc) {
        this.mamon = mamon;
        this.monhoc = monhoc;
    }
}
