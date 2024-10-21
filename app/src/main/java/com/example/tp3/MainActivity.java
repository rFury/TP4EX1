package com.example.tp3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameField, ageField, websiteField, phoneField;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.nameField);
        ageField = findViewById(R.id.ageField);
        websiteField = findViewById(R.id.websiteField);
        phoneField = findViewById(R.id.phoneField);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(v -> {
            boolean p = validateInputs();
            if (p) {
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("name", nameField.getText().toString());
                intent.putExtra("age", ageField.getText().toString());
                intent.putExtra("website", websiteField.getText().toString());
                intent.putExtra("phone", phoneField.getText().toString());
                startActivity(intent);
            } else {
                // Show a toast message when validation fails
                Toast.makeText(MainActivity.this, "Please fill all fields correctly!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateInputs() {
        boolean isValid = true;

        if (nameField.getText().toString().isEmpty()) {
            nameField.setBackgroundColor(Color.RED);
            isValid = false;
        } else {
            nameField.setBackgroundColor(Color.GREEN);
        }

        if (ageField.getText().toString().isEmpty()) {
            ageField.setBackgroundColor(Color.RED);
            isValid = false;
        } else {
            ageField.setBackgroundColor(Color.GREEN);
        }

        if (websiteField.getText().toString().isEmpty()) {
            websiteField.setBackgroundColor(Color.RED);
            isValid = false;
        } else {
            websiteField.setBackgroundColor(Color.GREEN);
        }

        if (phoneField.getText().toString().isEmpty()) {
            phoneField.setBackgroundColor(Color.RED);
            isValid = false;
        } else {
            phoneField.setBackgroundColor(Color.GREEN);
        }

        return isValid;
    }
}
