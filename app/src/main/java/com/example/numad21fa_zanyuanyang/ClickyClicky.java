package com.example.numad21fa_zanyuanyang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClickyClicky extends AppCompatActivity {

    Button btnA, btnB, btnC, btnD, btnE, btnF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicky_clicky);

        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        btnE = findViewById(R.id.btnE);
        btnF = findViewById(R.id.btnF);

        TextView answer = findViewById(R.id.answer);

        btnA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                answer.setText("A");
            }
        });
        btnB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                answer.setText("B");
            }
        });
        btnC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                answer.setText("C");
            }
        });
        btnD.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                answer.setText("D");
            }
        });
        btnE.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                answer.setText("E");
            }
        });
        btnF.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                answer.setText("F");
            }
        });

    }
}
