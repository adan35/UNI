package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Quiz extends AppCompatActivity {
    TextView roll, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        roll = (TextView) findViewById(R.id.rollText);
        name = (TextView) findViewById(R.id.nameText);
        String rollStr = getIntent().getStringExtra("key1");
        String nameStr = getIntent().getStringExtra("key2");
        roll.setText(rollStr);
        name.setText(nameStr);
    }
}