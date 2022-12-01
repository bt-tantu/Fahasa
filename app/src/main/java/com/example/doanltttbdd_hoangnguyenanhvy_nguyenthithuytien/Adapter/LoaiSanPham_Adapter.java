package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.ChitietHoaDon;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.LoaiSanPham;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.R;

import java.util.ArrayList;

public class LoaiSanPham_Adapter extends ArrayAdapter<LoaiSanPham> {

    Activity context = null;
    ArrayList<LoaiSanPham> myarray = null;
    int layoutID;

    public LoaiSanPham_Adapter(Activity context, int layoutID, ArrayList<LoaiSanPham>array) {
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
            final TextView tv1 = (TextView) convertView.findViewById(R.id.tvLoaisp_Xem);
            final TextView tv2 = (TextView) convertView.findViewById(R.id.tvTEnsp_Xem);

            final LoaiSanPham sp = myarray.get(position);

            tv1.setText(sp.getMaLoaiSP().toString());
            tv2.setText(sp.getTenLoaiSP().toString());


        }
        return convertView;
    }


}
