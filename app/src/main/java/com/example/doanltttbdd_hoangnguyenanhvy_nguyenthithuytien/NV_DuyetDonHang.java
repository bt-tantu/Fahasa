package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Adapter.Chitietdonhang_Nhanvien_Adapter;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.ChitietHoaDon;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.DonHang_HoaDon;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.SQLite.ChitietHoaDon_DAO;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.SQLite.DBHelper;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.SQLite.DonHang_HoaDon_DAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NV_DuyetDonHang extends AppCompatActivity {
TextView madh, ngay, ptvc, pttt, tongtien, tinhtrang;
ListView dschitiet;
Button duyet;
public Integer macv, madonhang, manv;
public Integer matt;

    private Chitietdonhang_Nhanvien_Adapter adapter;
    private ArrayList<ChitietHoaDon> listct;
    private ArrayList<DonHang_HoaDon> listdh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duyet_don_hang);
        //Khai báo
        madh = (TextView) findViewById(R.id.tvMa);
        ngay = (TextView) findViewById(R.id.tvNgay);
        ptvc = (TextView) findViewById(R.id.tvptvc);
        pttt = (TextView) findViewById(R.id.tvptttt);
        tongtien = (TextView) findViewById(R.id.tvtong);
        tinhtrang = (TextView) findViewById(R.id.tvtinhtrang);
        dschitiet = (ListView) findViewById(R.id.lvchitiet);
        duyet = (Button) findViewById(R.id.btnXuly) ;

        //Gọi db
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        //Nhận dữ liệu
        macv = Integer.valueOf(getIntent().getExtras().getString("chucvinhanvien"));
        madonhang = Integer.valueOf(getIntent().getExtras().getString("madonhang"));
        manv =  Integer.valueOf(getIntent().getExtras().getString("manhanvien"));
        //Khai báo các list
        listct = new ArrayList<ChitietHoaDon>();
        listdh = new ArrayList<DonHang_HoaDon>();

        //Khai báo DAO
        ChitietHoaDon_DAO cthd = new ChitietHoaDon_DAO(this);
        DonHang_HoaDon_DAO hd = new DonHang_HoaDon_DAO(this);

        //Dán adapter
        listct.addAll(cthd.getbyId(madonhang));
        adapter = new Chitietdonhang_Nhanvien_Adapter(this, R.layout.chitietdonhang_nhanvien_layout, listct);
        dschitiet.setAdapter(adapter);


        //Dán thông tin cho đơn hàng
        listdh.add(hd.getbyId_QT1(madonhang));
        madh.setText(listdh.get(0).getMadh().toString());
        ngay.setText(listdh.get(0).getNGAYTAO().toString());
        ptvc.setText(listdh.get(0).getPTVC().toString());
        pttt.setText(listdh.get(0).getPTTT().toString());
        tongtien.setText(listdh.get(0).getTongtien().toString());
        tinhtrang.setText(listdh.get(0).getTinhtrang().toString());
        matt = listdh.get(0).getMatt();




        switch (matt)
        {
            case 1:
            {
                duyet.setText("Xác nhận đơn hàng");
                break;
            }
            case 2:
            {
                duyet.setText("Hoàn tất đóng gói");
                break;

            }
            case 3:
            {

                duyet.setText("Đang giao hàng");
                break;
            }
            case 4:
            {
                duyet.setText("Giao hàng thành công");
                break;
            }

            default:
            {
                break;
            }
        }

        duyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                caidatnut();

            }
        });

    }

    public void caidatnut()
    {   DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //Lấy ngày
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateandTime = sdf.format(new Date());
        switch (matt)
        {
            case 1:
            {

                String sql ="Update tbdonhang set MATT = 2 where MADH = " + madonhang;
                db.execSQL(sql);
                String sql2 = "INSERT INTO tbLichsudh (MADH, MATT, MANV, NGAY) VALUES ( '" + madonhang.toString() + "' , '2', '" + manv.toString() + "', '"+ currentDateandTime + "' );";
                db.execSQL(sql2);
                finish();
                break;
            }
            case 2:
            {

                String sql ="Update tbdonhang set MATT = 3 where MADH = " + madonhang;
                db.execSQL(sql);
                String sql2 = "INSERT INTO tbLichsudh (MADH, MATT, MANV, NGAY) VALUES ( '" + madonhang.toString() + "' , '3', '" + manv.toString() + "', '"+ currentDateandTime + "' );";
                db.execSQL(sql2);
                finish();
                break;

            }
            case 3:
            {


                String sql ="Update tbdonhang set MATT = 4 where MADH = " + madonhang;
                db.execSQL(sql);
                String sql2 = "INSERT INTO tbLichsudh (MADH, MATT, MANV, NGAY) VALUES ( '" + madonhang.toString() + "' , '4', '" + manv.toString() + "', '"+ currentDateandTime + "' );";
                db.execSQL(sql2);
                finish();
                break;
            }
            case 4:
            {

                String sql ="Update tbdonhang set MATT = 5 where MADH = " + madonhang;
                db.execSQL(sql);
                String sql2 = "INSERT INTO tbLichsudh (MADH, MATT, MANV, NGAY) VALUES ( '" + madonhang.toString() + "' , '5', '" + manv.toString() + "', '"+ currentDateandTime + "' );";
                db.execSQL(sql2);
                finish();
                break;
            }

            default:
            {
                break;
            }
        }

    }
}