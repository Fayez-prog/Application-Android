package com.example.conversiontemprature;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


            public void add(View view) {
        LinearLayout ll=(LinearLayout)findViewById(R.id.ll);
        TextView result=(TextView)findViewById(R.id.result);
//get value fromedittext box and convertinto double
         EditText et1=(EditText)findViewById(R.id.editText1);
         double a=Double.parseDouble(String.valueOf(et1.getText()));
        RadioButton cb=(RadioButton)findViewById(R.id.cb);
        RadioButton fb=(RadioButton)findViewById(R.id.fb);
//check which radio buttonischecked
        if(cb.isChecked())
        {
//change background colour
            ll.setBackgroundColor(Color.YELLOW);
//display conversion
            result.setText(f2c(a) +" °C");
//cb.setChecked(false);
            fb.setChecked(true);
        }
        else
        {
            ll.setBackgroundColor(Color.CYAN);
            result.setText(c2f(a) +" °F");
//fb.setChecked(false);
            cb.setChecked(true);
        }
    }
    //Celcius to Fahrenhietmethod
     private double c2f(double c)
    {
        return(c*9)/5+32;
    }
    //Fahrenhiet to Celciusmethod
    private double f2c(double f)
    {
        return(f-32)*5/9;
    }
    public void setAlert(){
        AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Champ vide")
                .setMessage("veuillez saisir une valeur de température").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
