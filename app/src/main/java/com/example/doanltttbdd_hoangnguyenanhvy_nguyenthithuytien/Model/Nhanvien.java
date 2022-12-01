package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model;

public class Nhanvien {
    Integer Manv;
    String Hotennv, Sdt, Matkhau;
    Integer Macv;

    public Nhanvien() {
    }


    public Nhanvien(Integer manv, String hotennv, String sdt, String matkhau, Integer macv) {
        Manv = manv;
        Hotennv = hotennv;
        Sdt = sdt;
        Matkhau = matkhau;
        Macv = macv;
    }

    public Integer getManv() {
        return Manv;
    }

    public void setManv(Integer manv) {
        Manv = manv;
    }

    public String getHotennv() {
        return Hotennv;
    }

    public void setHotennv(String hotennv) {
        Hotennv = hotennv;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public String getMatkhau() {
        return Matkhau;
    }

    public void setMatkhau(String matkhau) {
        Matkhau = matkhau;
    }

    public Integer getMacv() {
        return Macv;
    }

    public void setMacv(Integer macv) {
        Macv = macv;
    }
}
