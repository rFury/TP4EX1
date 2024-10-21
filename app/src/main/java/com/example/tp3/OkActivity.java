package com.example.tp3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class OkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok);

        String phoneNumber = getIntent().getStringExtra("phone");
        String website = getIntent().getStringExtra("website");

        Button callButton = findViewById(R.id.callButton);
        Button browseButton = findViewById(R.id.browseButton);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + 216+phoneNumber));
                startActivity(callIntent);
            }
        });

        browseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse(website));
                startActivity(browserIntent);
            }
        });
    }
}
