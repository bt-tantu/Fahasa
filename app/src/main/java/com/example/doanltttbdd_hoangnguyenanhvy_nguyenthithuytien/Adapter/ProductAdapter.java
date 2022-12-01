package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.R;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    private final int resourceLayout;
    private final Context mContext;

    public ProductAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
        this.resourceLayout = resource;
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }

        Product p = getItem(position);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.id);
            TextView tt2 = (TextView) v.findViewById(R.id.name);
            ImageView imageView = (ImageView) v.findViewById(R.id.image);

            if (tt1 != null) {
                tt1.setText(String.valueOf(p.getId()));
            }

            if (tt2 != null) {
                tt2.setText(p.getName());
            }

            if (imageView != null) {
                Picasso.get().load(p.getImage_url()).placeholder(R.mipmap.ic_launcher).into(imageView);
            }
        }
        return v;
    }
}
