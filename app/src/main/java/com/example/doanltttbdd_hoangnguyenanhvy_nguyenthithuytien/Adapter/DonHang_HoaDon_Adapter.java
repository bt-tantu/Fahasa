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

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.DonHang_HoaDon;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.R;

import java.util.ArrayList;

public class DonHang_HoaDon_Adapter extends ArrayAdapter<DonHang_HoaDon> {
    Activity context = null;
    ArrayList<DonHang_HoaDon> myarray = null;
    int layoutID;

    public DonHang_HoaDon_Adapter(Activity context, int layoutID, ArrayList<DonHang_HoaDon>array) {
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
            final TextView tv1 = (TextView) convertView.findViewById(R.id.tvMadh);
            final TextView tv2 = (TextView) convertView.findViewById(R.id.tvvanchuyen);
            final TextView tv3 = (TextView) convertView.findViewById(R.id.tvthanhtoan);
            final TextView tv4 = (TextView) convertView.findViewById(R.id.tvngaytao);
            final TextView tv5 = (TextView) convertView.findViewById(R.id.tvtongtien);
            final TextView tv6 = (TextView) convertView.findViewById(R.id.tvtt);
            final ImageView ivanh = (ImageView) convertView.findViewById(R.id.ivQt);


            final DonHang_HoaDon sp = myarray.get(position);
            //Gán thông tin của model vào các control
            tv1.setText(String.valueOf(sp.getMadh()));
            tv2.setText(sp.getPTVC().toString());
            tv3.setText(String.valueOf(sp.getPTTT()).toString());
            tv4.setText( String.valueOf(sp.getNGAYTAO()).toString());
            tv5.setText(sp.getTongtien().toString() + " đồng");

            Integer matt = sp.getMatt();
            switch (matt)
            {
                case 1:
                {
                    ivanh.setImageResource( R.drawable.qt1);
                    break;
                }
                case 2:
                {
                    ivanh.setImageResource(R.drawable.qt2);
                    break;
                }
                case 3:
                {
                    ivanh.setImageResource(R.drawable.qt3);
                    break;
                }
                case 4:
                {
                    ivanh.setImageResource(R.drawable.qt4);
                    break;
                }
            }
            tv6.setText(sp.getTinhtrang().toString());

        }
        return convertView;
    }
}
