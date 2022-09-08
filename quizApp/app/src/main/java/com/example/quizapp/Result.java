package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class Result extends AppCompatActivity {

    TextView resultName;
    TextView resultRoll;
    TextView resultScore;
    String marks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String name = getIntent().getStringExtra("key4");
        String roll = getIntent().getStringExtra("key3");
        marks = getIntent().getStringExtra("key5") + "0";
        resultName = (TextView) findViewById(R.id.resultName);
        resultRoll = (TextView) findViewById(R.id.resultRoll);
        resultScore = (TextView) findViewById(R.id.resultScore);

        String n = "Name: " + name;
        resultName.setText(n);
        String r = "Roll Num: " + roll;
        resultRoll.setText(r);
        resultScore.setText(marks);

    }

    public void onShare(View view) {
        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.setType("text/plain");
        whatsappIntent.setPackage("com.whatsapp");
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, "my score is " + marks + " out of 100");
        try {
            startActivity(whatsappIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "error occurred during share", Toast.LENGTH_SHORT).show();
        }
    }

}