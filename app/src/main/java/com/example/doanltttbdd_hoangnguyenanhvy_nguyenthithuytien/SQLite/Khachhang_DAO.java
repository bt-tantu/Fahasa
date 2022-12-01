package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.SQLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.Khachhang;

import java.util.ArrayList;
import java.util.List;

public class Khachhang_DAO {
    private SQLiteDatabase db;

    //Cho phép ghi dữ liệu vào CSDL đang có
    public Khachhang_DAO (Context context)
    {
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }



    //Duyệt từng dòng trong bảng của csdl và trả về danh sách dòng đã đọc thông qua list
    @SuppressLint("Range")
    public List<Khachhang> get (String sql, String ...selectArgs)
    {
        List<Khachhang> list = new ArrayList<Khachhang>();
        Cursor cs = db.rawQuery(sql,selectArgs);
        while (cs.moveToNext())
        {
            //Lấy thông tin của các cột
            Khachhang sp = new Khachhang();
            sp.setMakh(cs.getInt(cs.getColumnIndex("MAKH")));
            sp.setHo(cs.getString(cs.getColumnIndex("HOKH")));
            sp.setTen(cs.getString(cs.getColumnIndex("TENKH")));
            sp.setSdt(cs.getString(cs.getColumnIndex("SDT")));
            sp.setDiachi(cs.getString(cs.getColumnIndex("DIACHI")));
            sp.setEmail(cs.getString(cs.getColumnIndex("EMAIL")));
            sp.setGioitinh(cs.getString(cs.getColumnIndex("GIOITINH")));
            sp.setNgaysinh(cs.getString(cs.getColumnIndex("NGAYSINH")));
            sp.setMatkhau(cs.getString(cs.getColumnIndex("MATKHAU")));
            sp.setTinhtrang(cs.getString(cs.getColumnIndex("TINHTRANG")));
            sp.setGhichu(cs.getString(cs.getColumnIndex("GHICHU")));
            list.add(sp);
        }
        return list;
    }


    //Đọc tất cả dữ liệu trong bảng (Lấy danh sách được trả về)
    public List<Khachhang> getAll()
    {
        String sql = "Select * from tbKhachhang";
        return  get(sql);
    }

    //Lấy - trả về thông tin (tên,mã,...) Khách hàng theo nhu cầu mã nhập vào
    public Khachhang getbyId (String MAKH)
    {
        String sql = "Select * from tbKhachhang where MAKH=?";
        List<Khachhang> list = get(sql,MAKH);
        return list.get(0);
    }

    //Thêm dữ liệu
    public long insert (Khachhang sp)
    {
        ContentValues values = new ContentValues();
        values.put("HOKH",  sp.getHo());
        values.put("TENKH", sp.getTen());
        values.put("SDT",  sp.getSdt());
        values.put("DIACHI", sp.getDiachi());
        values.put("EMAIL", sp.getEmail());
        values.put("GIOITINH",sp.getGioitinh());
        values.put("NGAYSINH", sp.getNgaysinh());
        values.put("MATKHAU", sp.getMatkhau());
        values.put("TINHTRANG", sp.getTinhtrang());
        values.put("GHICHU", sp.getGhichu());

        //db.insert("Khachhang", null, values);
        return db.insert("tbKhachhang", null, values);

    }
    public long update(Khachhang sp)
    {
        ContentValues values = new ContentValues();
        values.put("HOKH",  sp.getHo());
        values.put("TENKH", sp.getTen());
        values.put("SDT",  sp.getSdt());
        values.put("DIACHI", sp.getDiachi());
        values.put("EMAIL", sp.getEmail());
        values.put("GIOITINH",sp.getGioitinh());
        values.put("NGAYSINH", sp.getNgaysinh());
        values.put("MATKHAU", sp.getMatkhau());
        values.put("TINHTRANG", sp.getTinhtrang());
        values.put("GHICHU", sp.getGhichu());
        return db.update("tbKhachhang", values, "MAKH=", new String[]{String.valueOf(sp.getMakh())});
    }

    public int delete (String MaSP)
    {
        return db.delete("tbKhachhang", "MAKH=?", new String[] {MaSP});
    }

    public Boolean Kiemtra (String maso, String mk)
    {
        Cursor cs = db.rawQuery("Select * from tbKhachhang where MAKH = ? and MATKHAU =?", new String[] {maso.toString(),mk});
        if (cs.getCount() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }




}

