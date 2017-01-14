package com.ersarizkidimitri.jazz2017.about;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ersarizkidimitri.jazz2017.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragmentAboutNgisoringinJazz extends Fragment {
    @BindView(R.id.txt_list_kosong)TextView textListKosong;

    private static String TAG = FragmentAboutNgisoringinJazz.class.getSimpleName();
    private String techCode;

    public static FragmentAboutNgisoringinJazz newInstance() {
        return new FragmentAboutNgisoringinJazz();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_about_ngisoringin_jazz, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

}
