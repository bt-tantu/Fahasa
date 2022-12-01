package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.ChitietHoaDon;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.DonHang_HoaDon;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.R;

import java.util.ArrayList;

public class Chitietdonhang_Nhanvien_Adapter extends ArrayAdapter<ChitietHoaDon> {

    Activity context = null;
    ArrayList<ChitietHoaDon> myarray = null;
    int layoutID;

    public Chitietdonhang_Nhanvien_Adapter(Activity context, int layoutID, ArrayList<ChitietHoaDon>array) {
        super(context, layoutID, array);
        this.context = context;
        this.layoutID = layoutID;
        this.myarray = array;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutID, null);

        if (myarray.size() > 0 && position >= 0) {
            //Lấy control của các chức năng trong layout_item
            final TextView tv1 = (TextView) convertView.findViewById(R.id.tvmasp);
            final TextView tv2 = (TextView) convertView.findViewById(R.id.tvtensp);
            final TextView tv3 = (TextView) convertView.findViewById(R.id.tvsl);
            final TextView tv4 = (TextView) convertView.findViewById(R.id.tvtonkho);
            final TextView tv5 = (TextView) convertView.findViewById(R.id.textView10);

            final ChitietHoaDon sp = myarray.get(position);
            //Gán thông tin của model vào các control
            tv1.setText(String.valueOf(sp.getMasp()));
            tv2.setText(sp.getTensp().toString());
            tv3.setText(String.valueOf(sp.getSoluong()).toString());
            tv4.setText(String.valueOf(sp.getLuongton()));

            Integer matt = sp.getMatt();
            if (matt != 1)
            {
                tv4.setText("");
                tv5.setText("");
            }


        }
        return convertView;
    }
}
