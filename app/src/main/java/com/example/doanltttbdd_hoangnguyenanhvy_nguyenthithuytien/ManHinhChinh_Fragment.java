package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.SQLite.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ManHinhChinh_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ManHinhChinh_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ManHinhChinh_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ManHinhChinh_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ManHinhChinh_Fragment newInstance(String param1, String param2) {
        ManHinhChinh_Fragment fragment = new ManHinhChinh_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }


    }
  private   Spinner spinner;
    private Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DBHelper db = new DBHelper(this.getContext());
        SQLiteDatabase database2 = db.getReadableDatabase();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_man_hinh_chinh_, container, false);
        spinner = view.findViewById(R.id.spLoaiSP);
        List<String> tenloai = new ArrayList<String>();

        Cursor c1 = database2.rawQuery("select TENLOAISP from tbLoaisp", null);
        int ten = c1.getColumnIndex("TENLOAISP");
        while (c1.moveToNext())
        {
            tenloai.add(c1.getString(ten))  ;
        }
        ArrayAdapter<String> dataadapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item,tenloai);
        dataadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataadapter);
        button = view.findViewById(R.id.nutxoa);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database2.execSQL("PRAGMA foreign_keys=ON;");
                String sql = "Delete from tbLoaisp where MALOAISP = 2";
                database2.execSQL(sql);
            }
        });
        return view;


    }
}