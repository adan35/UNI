package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    EditText rollno, name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        rollno = (EditText) findViewById(R.id.rollno);
        name = (EditText) findViewById(R.id.name);
    }

    public void quizContent (View view) {
        Uri uri = Uri.parse("https://learn-quran-kids.com/tajweed/makharij-emission-points/");
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    public void startQuiz (View view) {
        String roll= rollno.getText().toString();
        String nam = name.getText().toString();
        Intent i = new Intent(getApplicationContext(), Quiz.class);
        i.putExtra("key1",roll);
        i.putExtra("key2",nam);
        startActivity(i);
    }
}