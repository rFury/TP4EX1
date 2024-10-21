package com.example.tp3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    Button okButton, retourButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        TextView nameView = findViewById(R.id.nameView);
        TextView ageView = findViewById(R.id.ageView);
        TextView websiteView = findViewById(R.id.websiteView);
        TextView phoneView = findViewById(R.id.phoneView);

        okButton = findViewById(R.id.okButton);
        retourButton = findViewById(R.id.retourButton);

        Intent intent = getIntent();
        nameView.setText(intent.getStringExtra("name"));
        ageView.setText(intent.getStringExtra("age"));
        websiteView.setText(intent.getStringExtra("website"));
        phoneView.setText(intent.getStringExtra("phone"));

        okButton.setOnClickListener(v -> {
            Intent okIntent = new Intent(DisplayActivity.this, OkActivity.class);
            okIntent.putExtra("website", websiteView.getText().toString());
            okIntent.putExtra("phone", phoneView.getText().toString());
            startActivity(okIntent);
        });

        retourButton.setOnClickListener(v -> finish());
    }
}
