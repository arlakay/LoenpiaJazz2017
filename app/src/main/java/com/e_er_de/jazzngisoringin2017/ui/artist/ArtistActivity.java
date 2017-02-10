package com.e_er_de.jazzngisoringin2017.ui.artist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.e_er_de.jazzngisoringin2017.BuildConfig;
import com.e_er_de.jazzngisoringin2017.R;
import com.e_er_de.jazzngisoringin2017.api.RestApi;
import com.e_er_de.jazzngisoringin2017.api.services.ApiService;
import com.e_er_de.jazzngisoringin2017.model.Artist;
import com.e_er_de.jazzngisoringin2017.model.ArtistResponse;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)Toolbar toolbar;
    @BindView(R.id.recycler_artist)RecyclerView recyclerViewArtist;

    public static String TAG = ArtistActivity.class.getSimpleName();
    List<Artist> artistList;
    private ArtistAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        ButterKnife.bind(this);

        setupToolbar();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewArtist.setLayoutManager(linearLayoutManager);
        recyclerViewArtist.setHasFixedSize(true);

        getAllArtist();

    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getSupportActionBar() == null) {
            throw new IllegalStateException("Activity must implement toolbar");
        }
    }

    private void getAllArtist() {

        ApiService apiService =
                RestApi.getClient().create(ApiService.class);

        Call<ArtistResponse> call = apiService.getAllArtist(BuildConfig.INGENICO_API_KEY);
        call.enqueue(new Callback<ArtistResponse>() {
            @Override
            public void onResponse(Call<ArtistResponse>call, Response<ArtistResponse> response) {

                artistList = response.body().getData();

                Log.d(TAG, "Status Code = " + response.code());
                Log.d(TAG, "Data of Events received: " + new Gson().toJson(artistList));

                if (response.isSuccessful() && response.body().getStatus()) {
                    adapter = new ArtistAdapter(artistList, R.layout.list_item_artist, getApplicationContext(), new ArtistAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(Artist model) {

//                            Intent intent = new Intent(ArtistActivity.this, DetailReviewJobActivity.class);
//                            intent.putExtra("job_id", jobId);
//                            intent.putExtra("tech_code", tecCode);
//                            intent.putExtra("start_time", startTime);
//                            intent.putExtra("finish_time", finishTime);
//                            intent.putExtra("cust_code", customerCode);
//                            intent.putExtra("term_code", terminalCode);
//                            intent.putExtra("func_code", func);
//                            intent.putExtra("symp_code", symp);
//                            intent.putExtra("spare_code", spare_code);
//                            intent.putExtra("resol_code", resol_code);
//
//                            startActivity(intent);
                        }
                    });
                    recyclerViewArtist.setAdapter(adapter);
                }else {


                }
            }

            @Override
            public void onFailure(Call<ArtistResponse>call, Throwable t) {
//                Log.e(TAG, t.toString());

                AlertDialog alertDialog = new AlertDialog.Builder(ArtistActivity.this).create();
                alertDialog.setTitle("Error");
                alertDialog.setMessage("Sorry, server respond's timed out" + t.getMessage());
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                        startActivity(getIntent());
                    }
                });
                alertDialog.show();
            }
        });
    }

}
