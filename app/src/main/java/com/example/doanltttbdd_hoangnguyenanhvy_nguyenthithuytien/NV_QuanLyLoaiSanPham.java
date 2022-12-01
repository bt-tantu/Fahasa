package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Adapter.DonHang_HoaDon_Adapter;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Adapter.LoaiSanPham_Adapter;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.DonHang_HoaDon;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.LoaiSanPham;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.SQLite.DonHang_HoaDon_DAO;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.SQLite.LoaiSanPham_DAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class NV_QuanLyLoaiSanPham extends AppCompatActivity {
    private ArrayList<LoaiSanPham> list;
    private LoaiSanPham_Adapter adapter;
    ListView loaisplv;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nv_quan_ly_loai_san_pham);
        LoaiSanPham_DAO loaispdao = new LoaiSanPham_DAO(this);
        loaisplv = (ListView) findViewById(R.id.lvLoaisp);
        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        list = new ArrayList<LoaiSanPham>();
        list.clear();
        list.addAll(loaispdao.getAll());
        adapter = new  LoaiSanPham_Adapter(this, R.layout.quanlyloaisanpham_activity, list);
        loaisplv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NV_QuanLyLoaiSanPham.this, NV_Them_LoaiSanPham.class);
                startActivity(i);
            }
        });

        loaisplv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent acti = new Intent(NV_QuanLyLoaiSanPham.this, NV_ChinhSua_LoaiSanPham.class);
                acti.putExtra("maloaisp", list.get(i).getMaLoaiSP().toString());
                startActivity(acti);
            }
        });

    }
    @Override
    protected void onResume() {


        super.onResume();
        LoaiSanPham_DAO hddao = new LoaiSanPham_DAO(this);
        ArrayList<LoaiSanPham> update = (ArrayList<LoaiSanPham>) hddao.getAll();


        list.clear();
        update.forEach(item->list.add(item));


        adapter.notifyDataSetChanged();




    }
}