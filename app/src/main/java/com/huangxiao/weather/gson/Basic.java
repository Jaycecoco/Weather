package com.huangxiao.weather.gson;
import com.google.gson.annotations.SerializedName;
/**
 * Created by Abbey on 2017/12/2 0002.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;
    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }

}
