package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model;

public class LoaiSanPham {
    Integer MaLoaiSP;
    String TenLoaiSP;

    public LoaiSanPham() {
    }

    public LoaiSanPham(Integer maLoaiSP, String tenLoaiSP) {
        MaLoaiSP = maLoaiSP;
        TenLoaiSP = tenLoaiSP;
    }

    public Integer getMaLoaiSP() {
        return MaLoaiSP;
    }

    public void setMaLoaiSP(Integer maLoaiSP) {
        MaLoaiSP = maLoaiSP;
    }

    public String getTenLoaiSP() {
        return TenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        TenLoaiSP = tenLoaiSP;
    }
}
