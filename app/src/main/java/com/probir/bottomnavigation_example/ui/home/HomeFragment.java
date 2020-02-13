package com.probir.bottomnavigation_example.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.probir.bottomnavigation_example.Adapter.QAdapter;
import com.probir.bottomnavigation_example.Models.QModel;
import com.probir.bottomnavigation_example.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private QModel[] qModels;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
        recyclerView = root.findViewById(R.id.RV_SubjectName);


        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        getSubjectName();
        return root;
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

        QAdapter adapter = new QAdapter(qModels);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}