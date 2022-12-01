package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.databinding.ActivityKhachHangManHinhChinhBinding;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.databinding.ActivityMainBinding;

public class KhachHang_ManHinhChinh_Activity extends AppCompatActivity {
ActivityKhachHangManHinhChinhBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKhachHangManHinhChinhBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new ManHinhChinh_Fragment());

        binding.bottomKhachhang.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.trangchu:
                    replaceFragment(new ManHinhChinh_Fragment());
                    break;
                case R.id.donhang:
                    replaceFragment(new DonHang_Fragment());
                    break;
                case R.id.taikhoan:
                    replaceFragment(new TaiKhoan_Khachhang_Frament());
                    break;
                case R.id.giohang:
                    replaceFragment(new Giohang_Khachang_Fragment());
                    break;
                case R.id.dangxuat:
                    finish();
                    break;
            }
            return true;
        });
}

public  void replaceFragment(Fragment frag){
    FragmentManager fragmant = getSupportFragmentManager();
    FragmentTransaction fragtrans = fragmant.beginTransaction();
    fragtrans.replace(R.id.frame_layout,frag);
    fragtrans.commit();

}
}