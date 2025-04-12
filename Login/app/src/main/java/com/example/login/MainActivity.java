package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt;
    int requestLoginCode=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(i,1);
            }
        });
    }
    public void onActivityResult(int loginCode,int resultCode,Intent i) {
        super.onActivityResult(loginCode, resultCode, i);
        if (requestLoginCode == loginCode) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, i.getData().toString(), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, i.getData().toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
}