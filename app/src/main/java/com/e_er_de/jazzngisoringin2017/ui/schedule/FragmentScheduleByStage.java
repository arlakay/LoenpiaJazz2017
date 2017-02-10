package com.e_er_de.jazzngisoringin2017.ui.schedule;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.e_er_de.jazzngisoringin2017.BuildConfig;
import com.e_er_de.jazzngisoringin2017.R;
import com.e_er_de.jazzngisoringin2017.api.RestApi;
import com.e_er_de.jazzngisoringin2017.api.services.ApiService;
import com.e_er_de.jazzngisoringin2017.model.Schedule;
import com.e_er_de.jazzngisoringin2017.model.ScheduleResponse;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by e_er_de on 01/02/2017.
 */

public class FragmentScheduleByStage extends Fragment {
    private static String TAG = FragmentScheduleByStage.class.getSimpleName();

    @BindView(R.id.recycler_schedule_stage)RecyclerView recyclerViewScheduleStage;

    private List<Schedule> scheduleList;
    private ScheduleAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_schedule_by_stage, container, false);
        ButterKnife.bind(this, rootView);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerViewScheduleStage.setLayoutManager(linearLayoutManager);
        recyclerViewScheduleStage.setHasFixedSize(true);

        getAllScheduleByStage();

        return rootView;
    }

    private void getAllScheduleByStage() {

        ApiService apiService =
                RestApi.getClient().create(ApiService.class);

        Call<ScheduleResponse> call = apiService.getAllScheduleByStage(BuildConfig.INGENICO_API_KEY);
        call.enqueue(new Callback<ScheduleResponse>() {
            @Override
            public void onResponse(Call<ScheduleResponse>call, Response<ScheduleResponse> response) {
                scheduleList = response.body().getData();

                Log.d(TAG, "Status Code = " + response.code());
                Log.d(TAG, "Data of Events received: " + new Gson().toJson(scheduleList));

                if (response.isSuccessful() && response.body().getStatus()) {
                    adapter = new ScheduleAdapter(scheduleList, R.layout.list_item_artist, getActivity(), new ScheduleAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(Schedule model) {

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
//                            startActivity(intent);
                        }
                    });
                    recyclerViewScheduleStage.setAdapter(adapter);
                }else {

                }
            }

            @Override
            public void onFailure(Call<ScheduleResponse>call, Throwable t) {
                AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                alertDialog.setTitle("Error");
                alertDialog.setMessage("Sorry, server respond's timed out" + t.getMessage());
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        getActivity().finish();
                        startActivity(getActivity().getIntent());
                    }
                });
                alertDialog.show();
            }
        });
    }

}
