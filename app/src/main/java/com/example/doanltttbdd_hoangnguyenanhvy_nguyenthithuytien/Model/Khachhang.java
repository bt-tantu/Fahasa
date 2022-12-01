package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model;

public class Khachhang {
    Integer Makh;
    String Ho, Ten, Sdt, Diachi, Email, Gioitinh, Ngaysinh, Matkhau, Tinhtrang, Ghichu;


    public Khachhang(Integer makh, String ho, String ten, String sdt, String diachi, String email, String gioitinh, String ngaysinh, String matkhau, String tinhtrang, String ghichu) {
        Makh = makh;
        Ho = ho;
        Ten = ten;
        Sdt = sdt;
        Diachi = diachi;
        Email = email;
        Gioitinh = gioitinh;
        Ngaysinh = ngaysinh;
        Matkhau = matkhau;
        Tinhtrang = tinhtrang;
        Ghichu = ghichu;
    }

    public Khachhang ()
    {

    }

    public Integer getMakh() {
        return Makh;
    }

    public void setMakh(Integer makh) {
        Makh = makh;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String ho) {
        Ho = ho;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        Gioitinh = gioitinh;
    }

    public String getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        Ngaysinh = ngaysinh;
    }

    public String getMatkhau() {
        return Matkhau;
    }

    public void setMatkhau(String matkhau) {
        Matkhau = matkhau;
    }

    public String getTinhtrang() {
        return Tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        Tinhtrang = tinhtrang;
    }

    public String getGhichu() {
        return Ghichu;
    }

    public void setGhichu(String ghichu) {
        Ghichu = ghichu;
    }
}
