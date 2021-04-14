package com.example.assigment.model;

public class Schedules {
    String ngayThang, thoiGian, maMonHoc, tenMonHoc, lop;

    public String getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(String ngayThang) {
        this.ngayThang = ngayThang;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public Schedules() {
    }

    public Schedules(String ngayThang, String maMonHoc, String tenMonHoc, String lop,String thoiGian) {
        this.ngayThang = ngayThang;
        this.thoiGian = thoiGian;
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.lop = lop;
    }

}
