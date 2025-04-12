package com.example.calculdelimc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final   String N="name";
    public static final String L="taille";
    public static final String M="poids";
    public static final String A="age";
    public String age,name,taille,poids ;
    private Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById((R.id.button));
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText editText =(EditText)findViewById(R.id.name);
                name = editText.getText().toString();

                editText =(EditText)findViewById(R.id.taille);
                taille = editText.getText().toString();

                editText =(EditText)findViewById(R.id.poids);
                poids = editText.getText().toString();

                editText =(EditText)findViewById(R.id.age);
                age = editText.getText().toString();

                if((name.isEmpty())||(taille.isEmpty())||(poids.isEmpty())||(age.isEmpty())){
                    setAlert();
                }
                else
                    setMessageToSend();
            }
        });
    }

    public void setMessageToSend(){
        Intent intent =new Intent(this, MainActivity2.class);


        intent.putExtra(N,name);
        intent.putExtra(L,taille);
        intent.putExtra(M,poids);
        intent.putExtra(A,age);
        startActivity(intent);
    }
    public void setAlert(){
        AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Champ vide")
                .setMessage("veuillez remplir toutes les champs").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}