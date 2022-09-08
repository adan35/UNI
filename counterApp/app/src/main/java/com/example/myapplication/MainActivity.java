package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button showMYToast,resetCounter;
    TextView counterText;
    public int counterInt=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showMYToast=findViewById(R.id.showMYToast);
        counterText=findViewById(R.id.counterText);
        resetCounter=findViewById(R.id.resetCounter);
        showMYToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterInt++;
                updateTExt(counterInt);

            }
        });
        resetCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterInt=0;
                updateTExt(counterInt);
            }
        });
    }
    public void updateTExt(int myCounter){
        counterText.setText(String.valueOf(myCounter));
    }
}