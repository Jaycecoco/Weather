package com.huangxiao.weather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abbey on 2017/12/3 0003.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;
    public class More{
        @SerializedName("txt")
        public String info;
    }
}
