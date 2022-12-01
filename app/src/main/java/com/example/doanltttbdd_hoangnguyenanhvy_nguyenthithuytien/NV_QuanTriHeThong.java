package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NV_QuanTriHeThong extends AppCompatActivity {
public  Integer Manvlamviec;
TextView manv;
Button loaisp, sanpham, donhang, nhanvien, khachhang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_tri_he_thong);
        Manvlamviec = Integer.valueOf(getIntent().getExtras().getString("manhanvien"));
        manv = (TextView) findViewById(R.id.tvManv);
        manv.setText("Mã nhân viên:" + Manvlamviec);

        loaisp =(Button) findViewById(R.id.btnLoaisp);
        sanpham=(Button) findViewById(R.id.btnsp);
         donhang=(Button) findViewById(R.id.btnDonhang);
         nhanvien=(Button) findViewById(R.id.btnNhanvien);
         khachhang = (Button) findViewById(R.id.btnKhachhang);

         loaisp.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(NV_QuanTriHeThong.this, NV_QuanLyLoaiSanPham.class);
                 startActivity(i);
             }
         });

    }
}