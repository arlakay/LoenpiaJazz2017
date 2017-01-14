package com.ersarizkidimitri.jazz2017.schedule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ersarizkidimitri.jazz2017.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @OnClick(R.id.btn_stage1)
    public void stageOne(View view) {
        // TODO submit data to server...
        Intent i = new Intent(StageActivity.this, ScheduleActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.btn_stage2)
    public void stageTwo(View view) {
        // TODO submit data to server...
        Intent i = new Intent(StageActivity.this, ScheduleActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.btn_stage3)
    public void stageThree(View view) {
        // TODO submit data to server...
        Intent i = new Intent(StageActivity.this, ScheduleActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.btn_stage4)
    public void stageFour(View view) {
        // TODO submit data to server...
        Intent i = new Intent(StageActivity.this, ScheduleActivity.class);
        startActivity(i);
    }

}
