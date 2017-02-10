package com.e_er_de.jazzngisoringin2017.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by e_er_de on 02/02/2017.
 */

public class ArtistResponse {

    @SerializedName("status")
    private boolean status;
    @SerializedName("data")
    private List<Artist> data;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Artist> getData() {
        return data;
    }

    public void setData(List<Artist> data) {
        this.data = data;
    }

}
