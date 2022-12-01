package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model;

public class ChitietHoaDon {
    Integer Masp, soluong, luongton, Matt;
    String Tensp;

    public ChitietHoaDon() {
    }

    public Integer getMasp() {

        return Masp;
    }

    public Integer getMatt() {
        return Matt;
    }

    public void setMatt(Integer matt) {
        Matt = matt;
    }

    public Integer getLuongton() {
        return luongton;
    }

    public void setLuongton(Integer luongton) {
        this.luongton = luongton;
    }

    public void setMasp(Integer masp) {
        Masp = masp;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String tensp) {
        Tensp = tensp;
    }
}
