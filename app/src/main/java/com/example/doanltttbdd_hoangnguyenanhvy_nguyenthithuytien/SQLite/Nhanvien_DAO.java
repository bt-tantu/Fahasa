package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.SQLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.Khachhang;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.Nhanvien;

import java.util.ArrayList;
import java.util.List;

public class Nhanvien_DAO {
    private SQLiteDatabase db;
    //Cho phép ghi dữ liệu vào CSDL đang có
    public Nhanvien_DAO (Context context)
    {
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }



    //Duyệt từng dòng trong bảng của csdl và trả về danh sách dòng đã đọc thông qua list
    @SuppressLint("Range")
    public List<Nhanvien> get (String sql, String ...selectArgs)
    {
        List<Nhanvien> list = new ArrayList<Nhanvien>();
        Cursor cs = db.rawQuery(sql,selectArgs);
        while (cs.moveToNext())
        {
            //Lấy thông tin của các cột
            Nhanvien sp = new Nhanvien();
            sp.setManv(cs.getInt(cs.getColumnIndex("MANV")));
            sp.setHotennv(cs.getString(cs.getColumnIndex("HOTENNV")));
            sp.setSdt(cs.getString(cs.getColumnIndex("SDT")));
            sp.setMatkhau(cs.getString(cs.getColumnIndex("MATKHAU")));
            sp.setMacv(cs.getInt(cs.getColumnIndex("MACV")));
            list.add(sp);
        }
        return list;
    }


    //Đọc tất cả dữ liệu trong bảng (Lấy danh sách được trả về)
    public List<Nhanvien> getAll()
    {
        String sql = "Select * from tbNhanvien";
        return  get(sql);
    }

    //Lấy - trả về thông tin (tên,mã,...) Khách hàng theo nhu cầu mã nhập vào
    public Nhanvien getbyId (String MANV)
    {
        String sql = "Select * from tbNhanvien where MANV=?";
        List<Nhanvien> list = get(sql,MANV);
        return list.get(0);
    }

    //Thêm dữ liệu
    public long insert (Nhanvien sp)
    {
        ContentValues values = new ContentValues();
        values.put("HOTENNV", sp.getHotennv());
        values.put("SDT",  sp.getSdt());
        values.put("MATKHAU", sp.getMatkhau());
        values.put("MACV", sp.getMacv());


        //db.insert("Nhanvien", null, values);
        return db.insert("tbNhanvien", null, values);

    }
    public long update(Nhanvien sp)
    {
        ContentValues values = new ContentValues();
        values.put("HOTENNV", sp.getHotennv());
        values.put("SDT",  sp.getSdt());
        values.put("MATKHAU", sp.getMatkhau());
        values.put("MACV", sp.getMacv());
        return db.update("tbNhanvien", values, "MANV=", new String[]{String.valueOf(sp.getManv())});
    }

    public int delete (String MaSP)
    {
        return db.delete("tbNhanvien", "MANV=?", new String[] {MaSP});
    }

    public Boolean Kiemtra (String maso, String mk)
    {
        Cursor cs = db.rawQuery("Select * from tbNhanvien where MANV = ? and MATKHAU =?", new String[] {maso.toString(),mk});
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
