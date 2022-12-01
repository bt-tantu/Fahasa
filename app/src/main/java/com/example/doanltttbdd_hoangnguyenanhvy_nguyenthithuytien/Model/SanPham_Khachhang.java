package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model;

public class SanPham_Khachhang {
    Integer Masp;
    String Tensp, Tenloai, Anh;
    Float Dongia;

    public SanPham_Khachhang() {
    }

    public Integer getMasp() {
        return Masp;
    }

    public void setMasp(Integer masp) {
        Masp = masp;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String tensp) {
        Tensp = tensp;
    }

    public String getTenloai() {
        return Tenloai;
    }

    public void setTenloai(String tenloai) {
        Tenloai = tenloai;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String anh) {
        Anh = anh;
    }

    public Float getDongia() {
        return Dongia;
    }

    public void setDongia(Float dongia) {
        Dongia = dongia;
    }
}
