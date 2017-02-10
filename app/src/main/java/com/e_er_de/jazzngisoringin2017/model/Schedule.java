package com.e_er_de.jazzngisoringin2017.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by e_er_de on 02/02/2017.
 */

public class Schedule {
        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("start_hour")
        private String start_hour;
        @SerializedName("end_hour")
        private String end_hour;
        @SerializedName("date")
        private String date;
        @SerializedName("stage")
        private int stage;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStart_hour() {
            return start_hour;
        }

        public void setStart_hour(String start_hour) {
            this.start_hour = start_hour;
        }

        public String getEnd_hour() {
            return end_hour;
        }

        public void setEnd_hour(String end_hour) {
            this.end_hour = end_hour;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getStage() {
            return stage;
        }

        public void setStage(int stage) {
            this.stage = stage;
        }

}
