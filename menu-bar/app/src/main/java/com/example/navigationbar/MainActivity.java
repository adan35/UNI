package com.example.navigationbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),"Setting",Toast.LENGTH_LONG);
                break;
            case R.id.action_tasks:
                Toast.makeText(getApplicationContext(),"Tasks",Toast.LENGTH_LONG);
                break;
            case R.id.action_signup:
                Toast.makeText(getApplicationContext(),"Sign Up",Toast.LENGTH_LONG);
                break;
            case R.id.action_signin:
                Toast.makeText(getApplicationContext(),"Sign In",Toast.LENGTH_LONG);
                break;
            case R.id.action_favorite:
                Toast.makeText(getApplicationContext(),"Favorite",Toast.LENGTH_LONG);
                break;
        }
        return true;
    }
}