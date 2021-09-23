package com.example.numad21fa_zanyuanyang;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        btnA.setOnTouchListener(new View.OnTouchListener(){
           @Override
           public boolean onTouch(View v, MotionEvent event){
               if(event.getAction() == MotionEvent.ACTION_DOWN){
                   answer.setText("A");
               }else if(event.getAction() == MotionEvent.ACTION_UP){
                   answer.setText("-");
               }
               return true;
           }
        });


        btnB.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    answer.setText("B");
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    answer.setText("-");
                }
                return true;
            }
        });
        btnC.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    answer.setText("C");
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    answer.setText("-");
                }
                return true;
            }
        });

        btnD.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    answer.setText("D");
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    answer.setText("-");
                }
                return true;
            }
        });

        btnE.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    answer.setText("E");
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    answer.setText("-");
                }
                return true;
            }
        });

        btnF.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    answer.setText("F");
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    answer.setText("-");
                }
                return true;
            }
        });

    }
}
