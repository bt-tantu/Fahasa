package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.SQLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.DonHang_HoaDon;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.Khachhang;

import java.util.ArrayList;
import java.util.List;

public class DonHang_HoaDon_DAO {

    private SQLiteDatabase db;

    //Cho phép ghi dữ liệu vào CSDL đang có
    public DonHang_HoaDon_DAO(Context context)
    {
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //Duyệt từng dòng trong bảng của csdl và trả về danh sách dòng đã đọc thông qua list
    @SuppressLint("Range")
    public List<DonHang_HoaDon> get (String sql, String ...selectArgs)
    {
        List<DonHang_HoaDon> list = new ArrayList<DonHang_HoaDon>();
        Cursor cs = db.rawQuery(sql,selectArgs);
        while (cs.moveToNext())
        {
            //Lấy thông tin của các cột
            DonHang_HoaDon sp = new DonHang_HoaDon();
            sp.setMadh(cs.getInt(cs.getColumnIndex("MADH")));
            sp.setMakh(cs.getInt(cs.getColumnIndex("MAKH")));
            sp.setPTVC(cs.getString(cs.getColumnIndex("PTVC")));
            sp.setPTTT(cs.getString(cs.getColumnIndex("PTTT")));
            sp.setNGAYTAO(cs.getString(cs.getColumnIndex("NGAYTAO")));
            sp.setTinhtrang(cs.getString(cs.getColumnIndex("TENTT")));
            sp.setTongtien(cs.getFloat(cs.getColumnIndex("TONGTIEN")));
            sp.setMatt(cs.getInt(cs.getColumnIndex("MATT")));
            list.add(sp);
        }
        return list;
    }

    //Đọc tất cả dữ liệu trong bảng (Lấy danh sách được trả về)
    public List<DonHang_HoaDon> getAll_QT1()
    {
        String sql = "Select dh.MADH, dh.MAKH, PTVC, PTTT, dh.NGAYTAO, TENTT, TONGTIEN, dh.MATT  " +
                     " from tbdonhang dh inner join tbhoadon hd on dh.MADH = hd.MADH inner join tbTinhtrangdonhang tt on dh.MATT = tt.MATT " +
                    " where dh.MATT = '1'";
        return  get(sql);
    }

    //Lấy - trả về thông tin (tên,mã,...) Khách hàng theo nhu cầu mã nhập vào
    public DonHang_HoaDon getbyId_QT1 (Integer MADH)
    {
        String sql = "Select dh.MADH, dh.MAKH, PTVC, PTTT, dh.NGAYTAO, TENTT, TONGTIEN, dh.MATT " +
                    " from tbdonhang dh inner join tbhoadon hd on dh.MADH = hd.MADH inner join tbTinhtrangdonhang tt on dh.MATT = tt.MATT " +
                    " where dh.MADH =?";
        List<DonHang_HoaDon> list = get(sql, String.valueOf(MADH));
        return list.get(0);
    }

    /*public DonHang_HoaDon getbyId_QT1_Daxuly (Integer MADH)
    {
        String sql = "Select dh.MADH, dh.MAKH, PTVC, PTTT, dh.NGAYTAO, TENTT, TONGTIEN, dh.MATT " +
                " from tbdonhang dh inner join tbhoadon hd on dh.MADH = hd.MADH inner join tbTinhtrangdonhang tt on dh.MATT = tt.MATT " +
                " where dh.MADH =?";
        List<DonHang_HoaDon> list = get(sql, String.valueOf(MADH));
        return list.get(0);
    }*/

    //Đọc tất cả dữ liệu trong bảng (Lấy danh sách được trả về) _ Chờ đóng gói
    public List<DonHang_HoaDon> getAll_QT2()
    {
        String sql = "Select dh.MADH, dh.MAKH, PTVC, PTTT, dh.NGAYTAO, TENTT, TONGTIEN, dh.MATT  " +
                " from tbdonhang dh inner join tbhoadon hd on dh.MADH = hd.MADH inner join tbTinhtrangdonhang tt on dh.MATT = tt.MATT " +
                " where dh.MATT = '2'";
        return  get(sql);
    }


    public List<DonHang_HoaDon> getAll_QT3()
    {
        String sql = "Select dh.MADH, dh.MAKH, PTVC, PTTT, dh.NGAYTAO, TENTT, TONGTIEN, dh.MATT  " +
                " from tbdonhang dh inner join tbhoadon hd on dh.MADH = hd.MADH inner join tbTinhtrangdonhang tt on dh.MATT = tt.MATT " +
                " where dh.MATT = '3' or dh.MATT = '4' ";
        return  get(sql);
    }


}
