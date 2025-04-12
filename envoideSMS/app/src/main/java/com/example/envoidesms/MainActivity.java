package com.example.envoidesms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    EditText e2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText e1=(EditText)findViewById(R.id.edt1);
        final EditText e2=(EditText)findViewById(R.id.edt2);
        Button b1=(Button)findViewById(R.id.btn);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String num=e1.getText().toString();
                String msg=e2.getText().toString();
                Intent i=new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+num));
                i.putExtra("sms_body",msg);
                startActivity(i);
            }
        });


    }
}