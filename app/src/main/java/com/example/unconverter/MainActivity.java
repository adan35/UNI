package com.example.unconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = (EditText) findViewById(R.id.editTextNumber2);
        TextView result = (TextView) findViewById(R.id.textView4);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String kg = editText.getText().toString();
                double cal = Integer.parseInt(kg) / 0.45;
                String Str = Double.toString(cal) + " pounds";
                result.setText(Str);
            }
        });
    }
}

