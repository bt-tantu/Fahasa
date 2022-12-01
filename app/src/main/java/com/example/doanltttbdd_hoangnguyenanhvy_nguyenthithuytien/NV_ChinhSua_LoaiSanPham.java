package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.LoaiSanPham;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.SQLite.DBHelper;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.SQLite.LoaiSanPham_DAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class NV_ChinhSua_LoaiSanPham extends AppCompatActivity {
public Integer Maloaisp;
private ArrayList<LoaiSanPham> list;
EditText ma, ten;
Button LoaispSua, LoaispXoa, Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nv_chinh_sua_loai_san_pham);

        DBHelper db = new DBHelper(this);
        SQLiteDatabase database2 = db.getReadableDatabase();

        list = new ArrayList<LoaiSanPham>();
        LoaiSanPham_DAO loaispdao = new LoaiSanPham_DAO(this);
        Maloaisp = Integer.valueOf(getIntent().getExtras().getString("maloaisp"));
        list.add(loaispdao.getbyId(String.valueOf(Maloaisp)));


        ma = (EditText) findViewById(R.id.edmaloaisp_Sua);
        ten = (EditText) findViewById(R.id.edtenloaisp_Sua);
        LoaispSua = (Button) findViewById(R.id.btnUpdate);
        LoaispXoa = (Button) findViewById(R.id.btnDEl);
        Back = (Button) findViewById(R.id.btnBack);

        ma.setText(list.get(0).getMaLoaiSP().toString());
        ten.setText(list.get(0).getTenLoaiSP().toString());




        LoaispSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database2.execSQL("PRAGMA foreign_keys=ON;");
                String update = "Update tbLoaisp SET TENLOAISP = '" + ten.getText().toString() + "' Where MALOAISP = '" + ma.getText().toString() + "' ";
                database2.execSQL(update);
                finish();
            }
        });

        LoaispXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database2.execSQL("PRAGMA foreign_keys=ON;");
                String update = "Delete from  tbLoaisp Where MALOAISP = " + ma.getText().toString();
                database2.execSQL(update);
                finish();
            }
        });


        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}