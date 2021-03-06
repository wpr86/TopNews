package com.carl.co.topnews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carl.co.topnews.R;

/**
 * Created by Host-0 on 2017/3/14.
 */

public class OtherFragment extends Fragment {
    private String type;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        type = args != null ? args.getString("type") : "";
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_other,container,false);
        TextView textView = (TextView)view.findViewById(R.id.fragment_other_text);
        textView.setText(type);
        return view;
    }
}
