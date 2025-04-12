package com.example.acesssitedesecolesingenieures;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ArrayList<HashMap<String, String>> values;
    HashMap<String, String> map;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst = findViewById(R.id.lst);
        values = new ArrayList<HashMap<String, String>>();
        map = new HashMap<String, String>();
        map.put("abreviation", "ENETC'OM");
        map.put("nom", "Ecolr Nationale d'électronique et télécommunications de Sfax");
        map.put("logo", String.valueOf(R.drawable.enetcom));
        values.add(map);

        map = new HashMap<String, String>();
        map.put("abreviation", "ENIS");
        map.put("nom", "Ecole Nationale d'ingenieur de Sfax");
        map.put("logo", String.valueOf(R.drawable.enis));
        values.add(map);

        map = new HashMap<String, String>();
        map.put("abreviation", "ENIM");
        map.put("nom", "Ecole Nationale d'ingenieur de Monastir");
        map.put("logo", String.valueOf(R.drawable.enim));
        values.add(map);

        map = new HashMap<String, String>();
        map.put("abreviation", "ENISO");
        map.put("nom", "Ecole Nationale d'ingenieur de Sousse");
        map.put("logo", String.valueOf(R.drawable.eniso));
        values.add(map);

        SimpleAdapter myAdapter = new SimpleAdapter(this.getBaseContext(), values, R.layout.item, new String[]{"abreviation", "nom", "logo"}, new int[]{R.id.abreviation, R.id.nom, R.id.logo});
        lst.setAdapter(myAdapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                map = (HashMap<String, String>) lst.getItemAtPosition(position);
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Choix");
                adb.setMessage("Vouler vous ouvrir la page web de l'ecole " + map.get("abrevation"));
                adb.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String s = map.get("abreviation");
                        switch (s) {
                            case "ENETC'OM":
                                Uri u = Uri.parse("http://www.enetcom.rnu.tn/");
                                Intent i = new Intent(Intent.ACTION_VIEW, u);
                                startActivity(i);
                                break;
                            case "ENIS":
                                Uri u1 = Uri.parse("http://www.enis.rnu.tn/");
                                Intent i1 = new Intent(Intent.ACTION_VIEW, u1);
                                startActivity(i1);
                                break;
                            case "ENIM":
                                Uri u2 = Uri.parse("http://www.enim.rnu.tn/index.php/fr/");
                                Intent i2 = new Intent(Intent.ACTION_VIEW, u2);
                                startActivity(i2);
                                break;
                            case "ENISO":
                                Uri u3 = Uri.parse("http://www.eniso.rnu.tn/fr/");
                                Intent i3 = new Intent(Intent.ACTION_VIEW, u3);
                                startActivity(i3);
                                break;
                        }
                    }
                });
                adb.setNegativeButton("non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                adb.show();

            }
        });
    }
}




