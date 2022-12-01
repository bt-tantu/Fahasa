package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
//    private this dbHelper;
    public static String ColumnName = "TENSP";
    public static String ColumnID = "MASP";
    public static String ColumnMALOAISP = "MALOAISP";
    public static String ColumnDONGIA = "DONGIA";
    public static String ColumnMAKHO = "MAKHO";
    public static String ColumnLUONGTON = "LUONGTON";
    public static String ColumnDVT = "DVT";
    public static String ColumnANH = "ANH";
    public static String TABLE_NAME = "tbsanpham";

    private final SQLiteDatabase database;

    public ProductDAO() {
        this.database = DBHelper.getInstance().getWritableDatabase();
    }

    public void insert(String name,String price,String cat,String stock,String unit,String warehouse,String image_url) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(ColumnName, name);
        contentValue.put(ColumnMALOAISP, cat);
        contentValue.put(ColumnDONGIA, price);
        contentValue.put(ColumnMAKHO, warehouse);
        contentValue.put(ColumnLUONGTON, stock);
        contentValue.put(ColumnDVT, unit);
        contentValue.put(ColumnANH, image_url);
        database.insert(TABLE_NAME, null, contentValue);
    }

    public int update(long id,String name,String price,String cat,String stock,String unit,String warehouse,String image_url) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ColumnName, name);
        contentValues.put(ColumnMALOAISP, cat);
        contentValues.put(ColumnDONGIA, price);
        contentValues.put(ColumnMAKHO, warehouse);
        contentValues.put(ColumnLUONGTON, stock);
        contentValues.put(ColumnDVT, unit);
        contentValues.put(ColumnANH, image_url);

        return database.update(TABLE_NAME, contentValues, ColumnID+" = ?", new String[] { String.valueOf(id) });
    }

    public void delete(long _id) {
        database.delete(TABLE_NAME, ColumnID+" = ?", new String[] { String.valueOf(_id) });
    }

    public List<Product>  filterByName(String name) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + ColumnName + " LIKE '%" + name + "%'";
        return get(sql);
    }

    public List<Product> getAll() {
        String sql="SELECT * FROM " + TABLE_NAME;
        return get(sql);
    }

    public List<Product> filterByCat(String catId) {
        if (catId == null || catId.equals("0")) {
            return getAll();
        }
        String sql="SELECT * FROM " + TABLE_NAME + " WHERE " + ColumnMALOAISP + " = ?";
        return get(sql, catId);
    }

    @SuppressLint("Range")
    public List<Product> get(String sql,String ... selectArgs) {
        List<Product> products = new ArrayList<>();
        Cursor cursor = database.rawQuery(sql, selectArgs);
        while (cursor.moveToNext()){
            Product product = new Product();
            product.setId(cursor.getInt(cursor.getColumnIndex(ColumnID)));
            product.setName(cursor.getString(cursor.getColumnIndex(ColumnName)));
            product.setCategoryId(cursor.getInt(cursor.getColumnIndex(ColumnMALOAISP)));
            product.setPrice(cursor.getInt(cursor.getColumnIndex(ColumnDONGIA)));
            product.setWarehouseId(cursor.getInt(cursor.getColumnIndex(ColumnMAKHO)));
            product.setStock(cursor.getInt(cursor.getColumnIndex(ColumnLUONGTON)));
            product.setUnit(cursor.getString(cursor.getColumnIndex(ColumnDVT)));
            product.setImage_url(cursor.getString(cursor.getColumnIndex(ColumnANH)));

            products.add(product);
        }
        cursor.close();
        return products;
    }

    @SuppressLint("Range")
    public Product getById(int id) {
        String sql="SELECT * FROM "+ TABLE_NAME + " WHERE " + ColumnID + " = ?";
        List<Product> list=get(sql,ColumnID);
        return list.get(0);
    }
}
