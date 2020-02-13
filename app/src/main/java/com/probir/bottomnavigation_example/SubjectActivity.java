package com.probir.bottomnavigation_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import com.probir.bottomnavigation_example.Adapter.DetailsAdapter;
import com.probir.bottomnavigation_example.Adapter.QAdapter;
import com.probir.bottomnavigation_example.Models.QModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SubjectActivity extends AppCompatActivity {
    private QModel[] qModels;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        recyclerView = findViewById(R.id.RV_SubjectName);

        getSubjectName();

    }

    public void getSubjectName() {

        qModels = new QModel[]{

                new QModel("John McEnroe"), new QModel("Mike Bryan"),
                new QModel("Jimmy Connors"), new QModel("Bob Bryan"),
                new QModel("Ilie Năstase"), new QModel("Rod Laver"),
                new QModel("Tom Okker"), new QModel("Roger Federer"),
                new QModel("Ilie Năstase"), new QModel("Rod Laver"),
                new QModel("Tom Okker"), new QModel("Roger Federer"),

        };

        /*DetailsAdapter adapter = new DetailsAdapter(qModels);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);*/
    }
}
