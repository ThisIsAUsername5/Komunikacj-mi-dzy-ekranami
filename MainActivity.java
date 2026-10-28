package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editCustomer;
    RadioGroup radioSize;
    CheckBox checkCheese;
    Button btnSummary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCustomer = findViewById(R.id.editCustomer);
        radioSize = findViewById(R.id.radioSize);
        checkCheese = findViewById(R.id.checkCheese);
        btnSummary = findViewById(R.id.btnSummary);

        btnSummary.setOnClickListener(v -> {
            String customer = editCustomer.getText()
                    .toString().trim();
            if (customer.isEmpty()) {
                editCustomer.setError(
                        "Podaj nazwe klienta"
                );
                editCustomer.requestFocus();
                return;
            }

            int selectedId = radioSize.getCheckedRadioButtonId();

            if (selectedId == -1) {
                return;
            }

            RadioButton selectedRadio =
                    findViewById(selectedId);

            String size = selectedRadio.getText().toString();

            boolean extraCheese = checkCheese.isChecked();

            Intent intent = new Intent(
                    MainActivity.this,
                    Summary.class
            );

            intent.putExtra("CUSTOMER", customer);
            intent.putExtra("SIZE", size);
            intent.putExtra("CHEESE", extraCheese);

            startActivity(intent);
        });
    }
}