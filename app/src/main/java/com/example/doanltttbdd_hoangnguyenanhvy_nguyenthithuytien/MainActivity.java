package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.Khachhang;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.Nhanvien;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.SQLite.DBHelper;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.SQLite.Khachhang_DAO;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.SQLite.Nhanvien_DAO;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
EditText ms, mk;
Button dn;
RadioButton kh, nv;
ArrayList<Nhanvien> nhanvien;
ArrayList<Khachhang> khachhang;
Khachhang_DAO khdao;
Nhanvien_DAO nvdao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ms = (EditText) findViewById(R.id.edmaso) ;
        mk = (EditText) findViewById(R.id.edmk);
        dn = (Button) findViewById(R.id.btndn);
        kh = (RadioButton) findViewById(R.id.rbkhachhang);
        nv = (RadioButton) findViewById(R.id.rbnhanvien);

        khdao = new Khachhang_DAO(this);
        nvdao = new Nhanvien_DAO(this);

        DBHelper db = new DBHelper(this);
        SQLiteDatabase database2 = db.getReadableDatabase();

        dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    dangnhap();
            }
        });

    }

    public void dangnhap()
    {
        String ten = ms.getText().toString();
        String matk = mk.getText().toString();

        if (kh.isChecked())
        {
            //Ki???m tra m???t kh???u, t??n ????ng nh???p
            boolean kiemtra = khdao.Kiemtra(ten, matk);
            if (kiemtra == true)
            {

                chuyenKhachhang(ten);
            }
            else
            {
                Toast.makeText(this, "Sai t??i kho???n ho???c m???t kh???u" + "\n" +" Vui l??ng ki???m tra l???i",Toast.LENGTH_SHORT).show();
            }

        }
        else if (nv.isChecked())
        {

            nhanvien = new ArrayList<>();

            //Ki???m tra m???t kh???u, t??n ????ng nh???p
            boolean kiemtra =  nvdao.Kiemtra(ten,matk);
            if (kiemtra ==  true)
            {
                nhanvien.add(nvdao.getbyId(ten));


                chuyenvaitro(ten);

            }
            else {
                Toast.makeText(this, "Sai t??i kho???n ho???c m???t kh???u" + "\n" +" Vui l??ng ki???m tra l???i",Toast.LENGTH_SHORT).show();
            }

        }
        else
        {
            Toast.makeText(this, "Vui l??ng ch???n vai tr?? ng?????i d??ng" + "\n" +" Vui l??ng ki???m tra l???i",Toast.LENGTH_SHORT).show();
        }

    }

    public void chuyenvaitro(String ten)
    {

        Toast.makeText(this, "????ng nh???p th??nh c??ng" ,Toast.LENGTH_SHORT).show();
        Nhanvien_DAO nvdao = new Nhanvien_DAO(this);
        nhanvien = new ArrayList<>();
        nhanvien.add(nvdao.getbyId(ten));
        Integer chucvu = nhanvien.get(0).getMacv();

        switch (chucvu)
        {
            case 1:
            {
                Intent i = new Intent(MainActivity.this, NV_QuanTriHeThong.class);
                i.putExtra("manhanvien", ten);
                i.putExtra("chucvinhanvien", chucvu.toString());
                startActivity(i);
                break;

            }
            case 2:
            {
                Intent i = new Intent(MainActivity.this, NV_QT1_TiepNhanDH_Activity.class);
                i.putExtra("manhanvien", ten);
                i.putExtra("chucvinhanvien",chucvu.toString());
                startActivity(i);
                break;

            }
            case 3:
            {
                Intent i = new Intent(MainActivity.this, NV_QT2_DongGoiDH_Activity.class);
                i.putExtra("manhanvien", ten);
                i.putExtra("chucvinhanvien", chucvu.toString());
                startActivity(i);
                break;

            }
            case 4:
            {
                Intent i = new Intent(MainActivity.this, NV_QT3_VanChuyenDH_Activity.class);
                i.putExtra("manhanvien", ten);
                i.putExtra("chucvinhanvien", chucvu.toString());
                startActivity(i);
                break;
            }
            case 5:
            {
                Intent i = new Intent(MainActivity.this, NV_KeToan_Activity.class);
                i.putExtra("manhanvien", ten);
                i.putExtra("chucvinhanvien",chucvu.toString());
                startActivity(i);
                break;
            }
            default:
            {

            }
        }


    }

    public void chuyenKhachhang (String ten)
    {
        Nhanvien_DAO nvdao = new Nhanvien_DAO(this);
        nhanvien = new ArrayList<>();
        nhanvien.add(nvdao.getbyId(ten));
        Integer chucvu = nhanvien.get(0).getMacv();

        Khachhang_DAO khdao = new Khachhang_DAO(this);
        khachhang = new ArrayList<>();
        khachhang.add(khdao.getbyId(ten));
        String tinhtrang = khachhang.get(0).getTinhtrang();

        if (tinhtrang.equals("Kh??a") == true)
        {
            Toast.makeText(this, "T??i kho???n c???a b???n ???? b??? kh??a" ,Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "????ng nh???p th??nh c??ng" ,Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, HomeActivity.class);
            i.putExtra("makhachhang", ten);
            startActivity(i);
        }
    }
}