package com.e_er_de.jazzngisoringin2017.ui.stages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.e_er_de.jazzngisoringin2017.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StageActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);
        ButterKnife.bind(this);

        setupToolbar();

    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getSupportActionBar() == null) {
            throw new IllegalStateException("Activity must implement toolbar");
        }
    }

}
