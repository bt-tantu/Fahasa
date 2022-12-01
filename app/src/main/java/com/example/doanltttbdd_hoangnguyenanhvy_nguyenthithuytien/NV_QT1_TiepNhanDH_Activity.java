package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Adapter.DonHang_HoaDon_Adapter;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.DonHang_HoaDon;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.SQLite.DonHang_HoaDon_DAO;

import java.util.ArrayList;

public class NV_QT1_TiepNhanDH_Activity extends AppCompatActivity {
ListView danhsach;
TextView manhanvienlamviec;
Spinner spdh;
private ArrayList<DonHang_HoaDon> list;
private DonHang_HoaDon_Adapter adapter;
public Integer Manvlamviec;
    public Integer Machucvu;
String MADH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiep_nhan_dh);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Khai báo liên kết/su dung data
        DonHang_HoaDon_DAO hddao = new DonHang_HoaDon_DAO(this);

        //Khai báo
        danhsach = (ListView) findViewById(R.id.lvDonhang);
        manhanvienlamviec = (TextView)findViewById(R.id.tvManv) ;


        //Nhận mã nhận viên đang làm việc
        Manvlamviec = Integer.valueOf(getIntent().getExtras().getString("manhanvien"));
        manhanvienlamviec.setText("Mã nhân viên: " + Manvlamviec);

       //Khai báo, dán dử liệu vào adapter
        list = new ArrayList<DonHang_HoaDon>();
        list.clear();
        list.addAll(hddao.getAll_QT1());
        adapter = new DonHang_HoaDon_Adapter(this, R.layout.thongtindonhang_nhanvien_layout, list);
        danhsach.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //
        danhsach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Manvlamviec = Integer.valueOf(getIntent().getExtras().getString("manhanvien"));
                Machucvu = Integer.valueOf(getIntent().getExtras().getString("chucvinhanvien"));
                Intent acti = new Intent(NV_QT1_TiepNhanDH_Activity.this, NV_DuyetDonHang.class);

                acti.putExtra("manhanvien", Manvlamviec.toString());
                acti.putExtra("madonhang", list.get(i).getMadh().toString());
                acti.putExtra("chucvinhanvien", Machucvu.toString());
                startActivity(acti);
                Toast.makeText(NV_QT1_TiepNhanDH_Activity.this, "Thong tin: " + list.get(i).getMadh().toString(),Toast.LENGTH_SHORT).show();
            }
        });



        //Set spinner
        /*String[] loaidh = {"Chờ duyệt", "Đã duyệt"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,loaidh);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spdh.setAdapter(adapter);
        spdh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0)
                {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/
    }
    @Override
    protected void onResume() {


        super.onResume();
        DonHang_HoaDon_DAO hddao = new DonHang_HoaDon_DAO(this);
        ArrayList<DonHang_HoaDon> update = (ArrayList<DonHang_HoaDon>) hddao.getAll_QT1();


        list.clear();
       update.forEach(item->list.add(item));


        adapter.notifyDataSetChanged();


    }

}