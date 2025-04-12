package com.example.calculdelimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //
        DecimalFormat df = new DecimalFormat("0.00");
        //

        Intent intent=getIntent();
        String name =intent.getStringExtra(MainActivity.N);
        String taille =intent.getStringExtra(MainActivity.L);
        String poids =intent.getStringExtra(MainActivity.M);
        String age =intent.getStringExtra(MainActivity.A);
        //
        String message = name + " a "+ age +" ans , pese "+poids+"Kg pour une taille de "+taille +"m." ;
        TextView textView =findViewById(R.id.textView9);
        textView.setText(message);
        //
        float imc= (float) (Float.parseFloat(poids)/Math.pow(Float.parseFloat(taille),2));
        TextView textView9 =findViewById(R.id.textView5);
        textView9.setText(df.format(imc));
        //
        String etat="etat" ;
        if(imc<=18.5) etat="Maigreur";
        else if(imc<25) etat="Normal" ;
        else if(imc<30) etat="Surpoids";
        else if(imc<40) etat="Obésité";
        else if(imc>40) etat="Obésité massive";
        TextView textView6 =findViewById(R.id.textView6);
        textView6.setText(etat);
        //
        //

    }
}