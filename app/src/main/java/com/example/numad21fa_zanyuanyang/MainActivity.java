package com.example.numad21fa_zanyuanyang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button getAboutBtn;
    private Button clickyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAboutBtn = findViewById(R.id.About);
        getAboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Name: Zanyuan Yang\nEmail: yang.za@northeastern.edu", Toast.LENGTH_SHORT).show();
            }
        });

        clickyButton = findViewById(R.id.clicky);
        clickyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ClickyClicky.class);
                startActivity(intent);
            }
        });
    }
}