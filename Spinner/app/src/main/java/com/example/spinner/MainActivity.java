package com.example.spinner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Spinner spinner_object;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner_object = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.intents, android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_object.setAdapter(adapter);
        Button but = (Button) findViewById(R.id.button1);
        but.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int position = spinner_object.getSelectedItemPosition();
        Intent intent=null;
        switch (position) {
            case 0:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.google.com"));
                break;
            case 1:
                // dials the call directly to the number specified
                 intent = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:(+216)2462799"));
                break;
            case 2:
                // opens up the to - dial but does not dials the number
                 intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:(+0216)2420479"));

                break;
            case 3:
                /*
                 * opens up the specified location in the google map by its
                 * longitude and latitude
                 */
                 intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:28.632323175362604,77.22595474023433?z=19"));

                break;
            case 4:
                // to search for sfax on google map
                 intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=sfax"));
                break;
            case 5:
                // opens up the camera to capture an image
                 intent = new Intent("android.media.action.IMAGE_CAPTURE");
                break;
            case 6:
                // opens up contacts menu of your phone
                 intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("content://contacts/people/"));
                break;
            case 7:
                // edits the first contact on your contact list
                 intent = new Intent(Intent.ACTION_EDIT,
                        Uri.parse("content://contacts/people/1"));
                break;


        }
        if (intent !=null) {
            startActivity(intent);
        }
    }

}


