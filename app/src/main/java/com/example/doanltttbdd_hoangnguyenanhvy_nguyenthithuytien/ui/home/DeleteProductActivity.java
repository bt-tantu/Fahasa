package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.ui.home;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.DAO.ProductDAO;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.R;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.databinding.ActivityDeleteProductBinding;

public class DeleteProductActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityDeleteProductBinding binding;
    ProductDAO productDAO = new ProductDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);

            binding = ActivityDeleteProductBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            setSupportActionBar(binding.toolbar);
            View createButton = findViewById(R.id.delete);
            createButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        String id = binding.editProductID.getText().toString();
                        productDAO.delete(Long.parseLong(id));
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
        } catch (Exception e) {
            e.printStackTrace();
        }


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