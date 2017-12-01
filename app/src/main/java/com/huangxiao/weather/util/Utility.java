package com.huangxiao.weather.util;

import android.text.TextUtils;

import com.huangxiao.weather.db.City;
import com.huangxiao.weather.db.County;
import com.huangxiao.weather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Abbey on 2017/11/30 0030.
 */

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public synchronized static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
//            String[] allProvinces=response.split(",");
//            if (allProvinces!=null&&allProvinces.length>0){
//                for (String p:allProvinces){
//                    String[] array=p.split("\\|");
//                    Province province=new Province();
//                    province.setProvinceCode(array[0]);
//                    province.setProvinceName(array[1]);
//                    //将解析出来的数据存储到Province表里
//                    weatherDB.saveProvince(province);
//                }
//                return true;
//            }
            try{
                JSONArray allProvinces=new JSONArray(response);
                for (int i=0;i<allProvinces.length();i++){
                    JSONObject provinceObject=allProvinces.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return  false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response,int provinceId){
        if (!TextUtils.isEmpty(response)){
//            String[] allCities=response.split(",");
//            if (allCities!=null && allCities.length>0){
//                for (String c:allCities){
//                    String[] array=c.split("\\|");
//                    City city=new City();
//                    city.setCityCode(array[0]);
//                    city.setCityName(array[1]);
//                    city.setProvinceId(provinceId);
//                    //将解析出来的数据存储到City表里
//                    weatherDB.saveCity(city);
//                }
//                return true;
//            }
            try{
                JSONArray allCities=new JSONArray(response);
                for (int i=0;i<allCities.length();i++){
                    JSONObject cityObject=allCities.getJSONObject(i);
                    City city=new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(String response,int cityId){
        if (!TextUtils.isEmpty(response)){
//            String[] allCounties=response.split(",");
//            if (allCounties!=null&&allCounties.length>0){
//                for (String c:allCounties){
//                    String[] array=c.split("\\|");
//                    County county=new County();
//                    county.setCountyCode(array[0]);
//                    county.setCountyName(array[1]);
//                    county.setCityId(cityId);
//                    //将解析出来的数据存储到County表里
//                    weatherDB.saveCounty(county);
//                }
//                return true;
//            }
            try{
                JSONArray allCounties=new JSONArray(response);
                for (int i=0;i<allCounties.length();i++){
                    JSONObject countyObject=allCounties.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
