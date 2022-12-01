package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.Category;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.R;


import java.util.List;

public class CategoryAdapter  extends ArrayAdapter<Category> {

    private final int resourceLayout;
    private final Context mContext;

    public CategoryAdapter(@NonNull Context context, int resource, @NonNull List<Category> objects) {
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

        Category p = getItem(position);
        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.id);
            TextView tt2 = (TextView) v.findViewById(R.id.name);

            if (tt1 != null) {
                tt1.setText(String.valueOf(p.getId()));
            }

            if (tt2 != null) {
                tt2.setText(p.getName());
            }
        }
        return v;
    }
}
