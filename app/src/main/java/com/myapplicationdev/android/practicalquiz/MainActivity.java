package com.myapplicationdev.android.practicalquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etBrand;
    EditText etLitre;

    Button btnInsert, btnRetrieve;

    TextView tv;

    ArrayList<Car> note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBrand = findViewById(R.id.etBrand);
        etLitre = findViewById(R.id.etLitre);
        btnInsert = findViewById(R.id.btnInsert);
        btnRetrieve = findViewById(R.id.btnRetrieve);
        tv = findViewById(R.id.tvResult);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                String brand = etBrand.getText().toString();
                Double litre = Double.parseDouble(etLitre.getText().toString());


                db.insertTask(brand,litre);
                db.close();

                Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
            }
        });

        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<Car> car = db.getCar();
//                ArrayList<String> data2 = db.getLitreContent();
//
//                ArrayList<Car> car = db.getCar();
                db.close();

                String txt = "";
                for (int i = 0; i < car.size(); i++) {
//                    Log.d("Database Content", i + ". "+car.get(i).getBrand() + car.get(i).getLitre());
                    txt += i + ". " + car.get(i).getBrand() + car.get(i).getLitre() + "\n";
                }


                tv.setText(txt);
            }
        });
    }
}
