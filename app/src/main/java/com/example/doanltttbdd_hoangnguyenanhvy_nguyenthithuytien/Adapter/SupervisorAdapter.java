package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.R;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.Supervisor;

import java.util.List;

public class SupervisorAdapter extends ArrayAdapter<Supervisor> {

    private final int resourceLayout;
    private final Context mContext;

    public SupervisorAdapter(@NonNull Context context, int resource, @NonNull List<Supervisor> objects) {
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

        Supervisor p = getItem(position);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.id);
            TextView tt2 = (TextView) v.findViewById(R.id.name);

            if (tt1 != null) {
                tt1.setText(String.valueOf(p.getId()));
            }

            if (tt2 != null) {
                tt2.setText(p.getFirstName() +" "+ p.getName());
            }
        }
        return v;
    }
}