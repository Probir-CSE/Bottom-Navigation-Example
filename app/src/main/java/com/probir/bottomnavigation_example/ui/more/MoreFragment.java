package com.probir.bottomnavigation_example.ui.more;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.probir.bottomnavigation_example.R;

public class MoreFragment extends Fragment {

    TextView textView;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);

        textView=view.findViewById(R.id.text_more);
        textView.setText("Fragment More");

        return view;
    }

}
