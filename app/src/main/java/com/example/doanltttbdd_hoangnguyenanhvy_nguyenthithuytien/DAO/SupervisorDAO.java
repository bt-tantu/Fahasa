package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.Supervisor;

import java.util.ArrayList;
import java.util.List;

public class SupervisorDAO {
//    private this dbHelper;
    public static String ColumnHOKH = "HOKH";
    public static String ColumnTenKH = "TENKH";
    public static String ColumnID = "MAKH";
    public static String ColumnEmail = "EMAIL";
    public static String ColumnPassword = "MATKHAU";
    public static String ColumnPhone = "SDT";
    public static String ColumnAddress = "DIACHI";
    public static String ColumnGender = "GIOITINH";
    public static String ColumnBirthDate = "NGAYSINH";
    public static String ColumnStatus = "TINHTRANG";
    public static String ColumnBio = "GHICHU";

    public static String TABLE_NAME = "tbKhachhang";

    private final SQLiteDatabase database;

    public SupervisorDAO() {
        this.database = DBHelper.getInstance().getWritableDatabase();
    }

    public void insert(String firstName,String lastName,String email,String password,String phone,String address,String gender,String birthDate,String status,String bio) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(ColumnHOKH, firstName);
        contentValue.put(ColumnTenKH, lastName);
        contentValue.put(ColumnEmail, email);
        contentValue.put(ColumnPassword, password);
        contentValue.put(ColumnPhone, phone);
        contentValue.put(ColumnAddress, address);
        contentValue.put(ColumnGender,gender);
        contentValue.put(ColumnBirthDate,birthDate);
        contentValue.put(ColumnStatus,status);
        contentValue.put(ColumnBio,bio);
        database.insert(TABLE_NAME, null, contentValue);
    }




    public void delete(long _id) {
        database.delete(TABLE_NAME, ColumnID + "=" + _id, null);
    }

    public List<Supervisor> getAll() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        return get(sql);
    }

    @SuppressLint("Range")
    public List<Supervisor> get(String sql, String... selectArgs) {
        List<Supervisor> products = new ArrayList<>();
        Cursor cursor = database.rawQuery(sql, selectArgs);
        while (cursor.moveToNext()){
            Supervisor s = new Supervisor();
            s.setId(cursor.getInt(cursor.getColumnIndex(ColumnID)));
            s.setName(cursor.getString(cursor.getColumnIndex(ColumnTenKH)));
            s.setFirstName(cursor.getString(cursor.getColumnIndex(ColumnHOKH)));
            products.add(s);
        }
        cursor.close();
        return products;
    }
}
