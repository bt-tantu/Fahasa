package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.SQLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.LoaiSanPham;

import java.util.ArrayList;
import java.util.List;

public class LoaiSanPham_DAO {
    private SQLiteDatabase db;

    //Cho phép ghi dữ liệu vào CSDL đang có
    public LoaiSanPham_DAO (Context context)
    {
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public void Dong()
    {
        LoaiSanPham_DAO.this.db.close();
    }

    //Duyệt từng dòng trong bảng của csdl và trả về danh sách dòng đã đọc thông qua list
    @SuppressLint("Range")
    public List<LoaiSanPham> get (String sql, String ...selectArgs)
    {
        List<LoaiSanPham> list = new ArrayList<LoaiSanPham>();
        Cursor cursor = db.rawQuery(sql,selectArgs);
        while (cursor.moveToNext())
        {
            //Lấy thông tin của các cột
            LoaiSanPham sp = new LoaiSanPham();
            sp.setMaLoaiSP(cursor.getInt(cursor.getColumnIndex("MALOAISP")));
            sp.setTenLoaiSP(cursor.getString(cursor.getColumnIndex("TENLOAISP")));

            list.add(sp);
        }
        return list;
    }

    //Đọc tất cả dữ liệu trong bảng (Lấy danh sách được trả về)
    public List<LoaiSanPham> getAll()
    {
        String sql = "Select * from tbLoaisp";
        return  get(sql);
    }


    //Lấy - trả về thông tin (tên,mã,sl,...) sản phẩm theo nhu cầu mã nhập vào
    public LoaiSanPham getbyId (String MASP)
    {
        String sql = "Select * from tbLoaisp where MALOAISP=?";
        List<LoaiSanPham> list = get(sql,MASP);
        return list.get(0);
    }

    /*//Thêm dữ liệu
    public long insert (LoaiSanPham sp)
    {
        ContentValues values = new ContentValues();
        values.put("MASP", sp.getMASP());
        values.put("TENSP", sp.getTENSP());
        values.put("SOLUONG", sp.getDOLUONG());
        values.put("DONGIA", sp.getDONGIA());
        values.put("DONVITINH", sp.getDONVITINH());
        //db.insert("SANPHAM", null, values);
        return db.insert("SANPHAM", null, values);

    }

    public long update(LoaiSanPham sp)
    {
        ContentValues values = new ContentValues();
        values.put("TENSP", sp.getTENSP());
        values.put("SOLUONG", sp.getDOLUONG());

        return db.update("SANPHAM", values, "MASP=", new String[]{String.valueOf(sp.getMASP())});
    }*/

    public int delete (String MaSP)
    {
        return db.delete("SANPHAM", "MaSP=?", new String[] {MaSP});
    }

}
