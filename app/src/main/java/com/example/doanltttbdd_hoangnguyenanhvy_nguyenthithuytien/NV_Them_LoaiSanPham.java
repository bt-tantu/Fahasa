package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.SQLite.DBHelper;

public class NV_Them_LoaiSanPham extends AppCompatActivity {
Button them;
EditText tenloaidp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nv_them_loai_san_pham);

        them = (Button) findViewById(R.id.btnthemloaisp);
        tenloaidp= (EditText) findViewById(R.id.edTenLoaisp_Them);

        DBHelper db = new DBHelper(this);
        SQLiteDatabase database2 = db.getReadableDatabase();

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sql = "INSERT INTO tbLoaisp (TENLOAISP) VALUES ('" + tenloaidp.getText().toString() + "'); ";
                database2.execSQL(sql);
                finish();
            }
        });
    }
}