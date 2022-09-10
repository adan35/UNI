package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onGitLink(View view) {
        Uri uri = Uri.parse("https://github.com/adan35/quizApp.git");
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    public void onNext(View view) {
        Intent gotoFirstActivity = new Intent(getApplicationContext(), FirstActivity.class);
        startActivity(gotoFirstActivity);
    }
}