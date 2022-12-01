package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.SQLite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ChitietHoaDon_DAO {

    private SQLiteDatabase db;

    //Cho phép ghi dữ liệu vào CSDL đang có
    public ChitietHoaDon_DAO(Context context)
    {
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //Duyệt từng dòng trong bảng của csdl và trả về danh sách dòng đã đọc thông qua list
    @SuppressLint("Range")
    public List<com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.ChitietHoaDon> get (String sql, String ...selectArgs)
    {
        List<com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.ChitietHoaDon> list = new ArrayList<com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.ChitietHoaDon>();
        Cursor cs = db.rawQuery(sql,selectArgs);
        while (cs.moveToNext())
        {
            //Lấy thông tin của các cột
            com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.ChitietHoaDon sp = new com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.ChitietHoaDon();
            sp.setMasp(cs.getInt(cs.getColumnIndex("MASP")));
            sp.setTensp(cs.getString(cs.getColumnIndex("TENSP")));
            sp.setSoluong(cs.getInt(cs.getColumnIndex("SL")));
            sp.setLuongton(cs.getInt(cs.getColumnIndex("LUONGTON")));
            sp.setMatt(cs.getInt(cs.getColumnIndex("MATT")));
            list.add(sp);
        }
        return list;
    }

    public List<com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.ChitietHoaDon> getbyId (Integer MADH)
    {
        String sql = "SELECT ct.MASP, TENSP, SL, LUONGTON, MATT " +
                        " from tbsanpham sp inner join tbCthd ct on sp.MASP = ct.MASP  " +
                                            "inner join tbhoadon hd on ct.MAHD = hd.MAHD " +
                                            "inner join tbdonhang dh on dh.MADH = hd.MADH " +
                        " where hd.MAHD = ?";

        return get(sql, String.valueOf(MADH));
    }
}
