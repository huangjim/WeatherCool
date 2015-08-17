package android.jim.com.weathercool.util;

import android.jim.com.weathercool.db.WeatherCoolDB;
import android.jim.com.weathercool.model.City;
import android.jim.com.weathercool.model.County;
import android.jim.com.weathercool.model.Province;
import android.text.TextUtils;

/**
 * Created by Jim Huang on 2015/8/17.
 */
public class Utility {
    public synchronized static boolean handleProvincesResponse(WeatherCoolDB weatherCoolDB
            , String response) {
        if (!TextUtils.isEmpty(response)) {
            String allProvinces[] = response.split(",");
            if (allProvinces != null && allProvinces.length > 0) {
                for (String p :
                        allProvinces) {
                    String array[] = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceName(array[1]);
                    province.setProvinceCode(array[0]);
                    weatherCoolDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean handleCitiesResponse(WeatherCoolDB weatherCoolDB, String response,
                                               int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            String allCities[] = response.split(",");
            if (allCities != null && allCities.length > 0) {
                for (String c :
                        allCities) {
                    String array[] = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    weatherCoolDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean handleCountiesReponse(WeatherCoolDB weatherCoolDB,
                                                String response,int cityId){
        if (!TextUtils.isEmpty(response)){
            String allCounties[]=response.split(",");
            if (allCounties!=null&&allCounties.length>0){
                for (String c :
                        allCounties) {
                    String array[]=c.split("\\|");
                    County county=new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    weatherCoolDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }
}
