package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    EditText id,password;
    Button bt;
    String result="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        id=findViewById(R.id.ed);
        password=findViewById(R.id.ed2);
        bt=findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id.getText().toString().equals("Sumit")) {
                    if (password.getText().toString().equals("jain")) {
                        result = "login Successful";
                    }
                } else {
                    result = "Login Failed";
                }
                Intent intent = new Intent();
                intent.setData(Uri.parse(result));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}