package com.example.pafio.ex5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by pafio on 23-Mar-18.
 */

public class TabFragment extends Fragment {

    private static final String TAG = "TabFragment";
    private String textValue;

    public TabFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null) {
            textValue = getArguments().getString("textValue");
        }
    }

    public static TabFragment newInstance(String textValue) {
        TabFragment tabFragment = new TabFragment();

        Bundle args = new Bundle();
        args.putString("textValue", textValue);
        tabFragment.setArguments(args);

        return tabFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.tab_fragment, container, false);
        TextView textView  = layout.findViewById(R.id.fragmentTextView);

        textView.setText(textValue);
        return layout;
    }

}
