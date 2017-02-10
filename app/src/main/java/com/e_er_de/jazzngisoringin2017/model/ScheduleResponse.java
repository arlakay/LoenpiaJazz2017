package com.e_er_de.jazzngisoringin2017.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by e_er_de on 02/02/2017.
 */

public class ScheduleResponse {
    @SerializedName("status")
    private boolean status;
    @SerializedName("data")
    private List<Schedule> data;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Schedule> getData() {
        return data;
    }

    public void setData(List<Schedule> data) {
        this.data = data;
    }

}
