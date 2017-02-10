package com.e_er_de.jazzngisoringin2017.ui.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.e_er_de.jazzngisoringin2017.R;

import butterknife.ButterKnife;

/**
 * Created by e_er_de on 01/02/2017.
 */

public class FragmentNewsSocialMedia extends Fragment {
    private static String TAG = FragmentNewsSocialMedia.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_news_social_media, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

}
