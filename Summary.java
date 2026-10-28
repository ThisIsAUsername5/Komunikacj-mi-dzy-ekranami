package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Summary extends AppCompatActivity {

    TextView txtCustomer, txtSize, txtCheese;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        txtCustomer = findViewById(R.id.txtCustomer);
        txtSize = findViewById(R.id.txtSize);
        txtCheese = findViewById(R.id.txtCheese);
        btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();

        String customer = intent.getStringExtra("CUSTOMER");
        String size = intent.getStringExtra("SIZE");
        boolean extraCheese = intent.getBooleanExtra(
                "CHEESE", false
        );

        txtCustomer.setText("Klient: " + customer);
        txtSize.setText("Rozmiar pizzy: " + size);

        if (extraCheese) {
            txtCheese.setText("Dodatkowy ser: Tak");
        } else {
            txtCheese.setText("Dodatkowy ser: Nie");
        }
        
        btnBack.setOnClickListener(v -> finish());
    }
}