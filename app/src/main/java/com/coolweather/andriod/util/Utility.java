package com.coolweather.andriod.util;

import android.text.TextUtils;

import com.coolweather.andriod.db.City;
import com.coolweather.andriod.db.County;
import com.coolweather.andriod.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by cute on 2017/12/21.
 */

public class Utility {
    /*
    * 解析和处理服务器返回的省级数据
    * */
    public static boolean handleProvinceRespones(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvinces = new JSONArray(response);
                for(int i=0;i<allProvinces.length();i++){
                    JSONObject provinceObject =allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return  true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return  false;
    }
    /*
    * 解析和处理服务器返回的市级数据
    * */
    public static  boolean handleCityResponse(String respones,int provinceId){
        if(!TextUtils.isEmpty(respones)){
            try{
                JSONArray allCities = new JSONArray(respones);
                for(int i=0;i<allCities.length();i++){
                    JSONObject cityObject =allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return  true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return  false;
    }
      /*
    * 解析和处理服务器返回的县级数据
    * */
      public  static boolean handleCountyResponse(String respone,int cityId){
          if(!TextUtils.isEmpty(respone)){
              try{
                  JSONArray allCounties = new JSONArray(respone);
                  for(int i=0;i<allCounties.length();i++){
                      JSONObject countyObject =allCounties.getJSONObject(i);
                      County county = new County();
                      county.setCountyName(countyObject.getString("name"));
                      county.setCountyId(countyObject.getInt("id"));
                      county.setCountyId(cityId);
                      county.save();
                  }
                  return  true;
              }catch (JSONException e){
                  e.printStackTrace();
              }
          }
          return  false;
      }
}
