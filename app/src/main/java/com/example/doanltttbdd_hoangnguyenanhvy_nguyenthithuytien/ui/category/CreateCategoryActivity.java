package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.ui.category;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.DAO.CategoryDAO;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.R;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.databinding.ActivityCreateCatBinding;

public class CreateCategoryActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityCreateCatBinding binding;
    CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);

            binding = ActivityCreateCatBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            setSupportActionBar(binding.toolbar);
        } catch (Exception e) {
            e.printStackTrace();
        }

        View createButton = findViewById(R.id.submit);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String name = binding.catName.getText().toString();
                    categoryDAO.insert(name);
                    onBackPressed();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        View cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}