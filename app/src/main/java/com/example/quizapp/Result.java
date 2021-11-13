package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Result extends AppCompatActivity {

    TextView resultName;
    TextView resultRoll;
    TextView resultScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String name = getIntent().getStringExtra("key4");
        String roll = getIntent().getStringExtra("key3");
        String marks = getIntent().getStringExtra("key5") + "0";
        resultName = (TextView) findViewById(R.id.resultName);
        resultRoll = (TextView) findViewById(R.id.resultRoll);
        resultScore = (TextView) findViewById(R.id.resultScore);

        String n = "Name: " + name;
        resultName.setText(n);
        String r = "Roll Num: " + roll;
        resultRoll.setText(r);
        resultScore.setText(marks);
    }
}