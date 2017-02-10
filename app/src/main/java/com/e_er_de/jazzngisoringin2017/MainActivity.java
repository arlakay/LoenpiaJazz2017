package com.e_er_de.jazzngisoringin2017;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import com.e_er_de.jazzngisoringin2017.ui.about.AboutActivity;
import com.e_er_de.jazzngisoringin2017.ui.artist.ArtistActivity;
import com.e_er_de.jazzngisoringin2017.ui.map.MapActivity;
import com.e_er_de.jazzngisoringin2017.ui.merchandise.MerchandiseActivity;
import com.e_er_de.jazzngisoringin2017.ui.news.NewsTabsActivity;
import com.e_er_de.jazzngisoringin2017.ui.photobooth.PhotoboothTabsActivity;
import com.e_er_de.jazzngisoringin2017.ui.recommender.RecommenderActivity;
import com.e_er_de.jazzngisoringin2017.ui.schedule.ScheduleTabsActivity;
import com.e_er_de.jazzngisoringin2017.ui.stages.StageActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    ImageButton btnPlay1, btnPlay2, btnPlay3, btnPlay4;
    VideoView video1, video2, video3, video4;
    MediaController mediaC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnPlay1 = (ImageButton) findViewById(R.id.btn1);
        btnPlay2 = (ImageButton) findViewById(R.id.btn2);
        btnPlay3 = (ImageButton) findViewById(R.id.btn3);
        btnPlay4 = (ImageButton) findViewById(R.id.btn4);

        video1 = (VideoView) findViewById(R.id.video1);
        video2 = (VideoView) findViewById(R.id.video2);
        video3 = (VideoView) findViewById(R.id.video3);
        video4 = (VideoView) findViewById(R.id.video4);

        mediaC = new MediaController(this);

        btnPlay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String videopath = "android.resource://com.e_er_de.jazzngisoringin2017/" + R.raw.after_movie_loenpia_jazz;
                Uri uri = Uri.parse(videopath);
                video1.setVideoURI(uri);
                video1.seekTo(100);
                video1.setMediaController(mediaC);
                mediaC.setAnchorView(video1);
                video1.start();

                btnPlay1.setVisibility(View.GONE);
            }
        });
    }

    @OnClick(R.id.txt_about)
    public void about(View view) {
        Intent i = new Intent(this, AboutActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.txt_map)
    public void map(View view) {
        Intent i = new Intent(this, MapActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.txt_artist)
    public void artist(View view) {
        Intent i = new Intent(this, ArtistActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.txt_stages)
    public void stages(View view) {
        Intent i = new Intent(this, StageActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.txt_merchandise)
    public void merchandise(View view) {
        Intent i = new Intent(this, MerchandiseActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.txt_recommend)
    public void recommender(View view) {
        Intent i = new Intent(this, RecommenderActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.txt_news)
    public void news(View view) {
        Intent i = new Intent(this, NewsTabsActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.txt_schedule)
    public void schedule(View view) {
        Intent i = new Intent(this, ScheduleTabsActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.txt_photobooth)
    public void photobooth(View view) {
        Intent i = new Intent(this, PhotoboothTabsActivity.class);
        startActivity(i);
    }



}

