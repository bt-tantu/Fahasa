package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.ui.home;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.DAO.ProductDAO;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.R;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.databinding.ActivityCreateProductBinding;

public class CreateProductActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityCreateProductBinding binding;
    ProductDAO productDAO = new ProductDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);

            binding = ActivityCreateProductBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            setSupportActionBar(binding.toolbar);

        } catch (Exception e) {
            e.printStackTrace();
        }

        View createButton = findViewById(R.id.createProductButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String name = binding.editProductName.getText().toString();
                    String price = binding.editProductPrice.getText().toString();
                    String cat = binding.editProductCat.getText().toString();
                    String stock = binding.editProductStock.getText().toString();
                    String unit = binding.editProductUnit.getText().toString();
                    String warehouse = binding.editProductWarehouse.getText().toString();
                    String image_url = binding.editProductImg.getText().toString();

                    productDAO.insert(name, price, cat, stock, unit, warehouse, image_url);
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



//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_create_product);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
}