package com.probir.bottomnavigation_example.TestBox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.probir.bottomnavigation_example.R;

public class TestActivity extends AppCompatActivity {

    private TextView quantityTV;
    private Button addBTN;
    private int defultQientity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        quantityTV = findViewById(R.id.TV_quantity);
        addBTN = findViewById(R.id.BTN_add);

        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int up=defultQientity+1;
                int upp=up++;
                quantityTV.setText(String.valueOf(upp));
            }
        });
    }

    public void remove(View view) {
        if (defultQientity>0) {
            int up=defultQientity-1;
            quantityTV.setText(String.valueOf(up));
        }
        else {
            Toast.makeText(this, ">0",Toast.LENGTH_SHORT).show();
        }
    }
}


