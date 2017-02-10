package com.e_er_de.jazzngisoringin2017.ui.photobooth;

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

public class FragmentPhotoboothGallery extends Fragment {
    private static String TAG = FragmentPhotoboothGallery.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_photo_gallery, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

}
