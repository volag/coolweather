package com.coolweather.andriod.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by cute on 2017/12/22.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public  Update update;

    public  class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
