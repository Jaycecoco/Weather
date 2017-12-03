package com.huangxiao.weather.gson;

/**
 * Created by Abbey on 2017/12/3 0003.
 */

public class AQI {
    public AQICity city;
    public class AQICity{
        public String aqi;
        private String pm25;
    }

}
