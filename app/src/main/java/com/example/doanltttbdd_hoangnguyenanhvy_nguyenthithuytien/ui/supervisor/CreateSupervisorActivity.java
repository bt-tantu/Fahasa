package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.ui.supervisor;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.DAO.SupervisorDAO;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.R;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.databinding.ActivityCreateSupervisorBinding;

public class CreateSupervisorActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityCreateSupervisorBinding binding;
    SupervisorDAO supervisorDAO = new SupervisorDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);

            binding = ActivityCreateSupervisorBinding.inflate(getLayoutInflater());
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
                    String firstName = binding.fistName.getText().toString();
                    String lastName = binding.lastName.getText().toString();
                    String email = binding.email.getText().toString();
                    String password = binding.password.getText().toString();
                    String phone = binding.phone.getText().toString();
                    String address = binding.address.getText().toString();
                    String gender = binding.gender.getText().toString();
                    String birthDate = binding.birthDate.getText().toString();
                    String status = binding.status.getText().toString();
                    String bio = binding.bio.getText().toString();

                    supervisorDAO.insert(firstName, lastName, email, password, phone, address,gender, birthDate, status, bio);
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