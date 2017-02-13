package com.e_er_de.jazzngisoringin2017.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by e_er_de on 02/02/2017.
 */

public class Artist {

    @SerializedName("id")
    private int id;
    @SerializedName("schedule_id")
    private String schedule_id;
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private String type;
    @SerializedName("recommender")
    private String recommender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(String schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRecommender() {
        return recommender;
    }

    public void setRecommender(String recommender) {
        this.recommender = recommender;
    }

}
