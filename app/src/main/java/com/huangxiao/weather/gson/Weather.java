package com.huangxiao.weather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Abbey on 2017/12/3 0003.
 */

public class Weather {
    public String status;
    public Basic basic;
    public AQI aqi;
    public Now now;
    public Suggestion suggestion;
    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;

    @Override
    public String toString() {
        return super.toString();
    }
}
