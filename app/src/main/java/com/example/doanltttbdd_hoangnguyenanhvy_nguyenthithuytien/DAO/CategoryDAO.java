package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAO  {
    public static String ColumnName = "TENLOAISP";
    public static String ColumnID = "MALOAISP";
    public static String TABLE_NAME = "tbLoaisp";

    private final SQLiteDatabase database;

    public CategoryDAO() {
        this.database = DBHelper.getInstance().getWritableDatabase();
    }

    public List<Category> getAll() {
        String sql="SELECT * FROM LOAISP";
        return get(sql);
    }

    public void insert(String name) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(ColumnName, name);
        database.insert(TABLE_NAME, null, contentValue);
    }

    @SuppressLint("Range")
    public List<Category> get(String sql, String... selectArgs) {
        List<Category> cats = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        while (cursor.moveToNext()){
            Category category = new Category();
            category.setId(cursor.getInt(cursor.getColumnIndex(ColumnID)));
            category.setName(cursor.getString(cursor.getColumnIndex(ColumnName)));
            cats.add(category);
        }
        cursor.close();
        return cats;
    }
}
