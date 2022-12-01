package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model;

public class DonHang_HoaDon {
    Integer Madh, Makh, Matt;



    String PTVC, PTTT, NGAYTAO, Tinhtrang;
    Float Tongtien;

    public DonHang_HoaDon(Integer madh, Integer makh, String PTVC, String PTTT, String NGAYTAO, String tinhtrang, Float tongtien) {
        Madh = madh;
        Makh = makh;
        this.PTVC = PTVC;
        this.PTTT = PTTT;
        this.NGAYTAO = NGAYTAO;
        Tinhtrang = tinhtrang;
        Tongtien = tongtien;
    }

    public DonHang_HoaDon() {
    }



    public Integer getMadh() {
        return Madh;
    }

    public void setMadh(Integer madh) {
        Madh = madh;
    }


    public Integer getMakh() {
        return Makh;
    }

    public void setMakh(Integer makh) {
        Makh = makh;
    }



    public String getPTVC() {
        return PTVC;
    }

    public void setPTVC(String PTVC) {
        this.PTVC = PTVC;
    }

    public String getPTTT() {
        return PTTT;
    }

    public void setPTTT(String PTTT) {
        this.PTTT = PTTT;
    }

    public String getNGAYTAO() {
        return NGAYTAO;
    }

    public void setNGAYTAO(String NGAYTAO) {
        this.NGAYTAO = NGAYTAO;
    }

    public String getTinhtrang() {
        return Tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        Tinhtrang = tinhtrang;
    }

    public Float getTongtien() {
        return Tongtien;
    }

    public void setTongtien(Float tongtien) {
        Tongtien = tongtien;
    }


    //Chỉ dùng để truy xuất
    public Integer getMatt() {
        return Matt;
    }

    public void setMatt(Integer matt) {
        Matt = matt;
    }
}
