package com.example.zakat_calculator;

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
        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        TextView zakat = (TextView) findViewById(R.id.textView4);
        Button btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.parseDouble(editText.getText().toString());
                double zakat_amount = 0;
                if (amount > 81322.5) {
                    zakat_amount = amount * 0.25;
                }
                String str = Double.toString(zakat_amount) + " Rs";
                zakat.setText(str);
            }
        });
    }
}