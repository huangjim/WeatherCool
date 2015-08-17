package android.jim.com.weathercool.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by huangjim on 8/17/2015.
 */
public class WeatherCoolOpenHelper extends SQLiteOpenHelper {

    public static final String CREATE_PROVINCE="create table Province (" +
            "_id integer primary key autoincrement, " +
            "province_name text, " +
            "province_code text)";
    public static final String CREATE_CITY="create table City (" +
            "_id integer primary key autoincrement, " +
            "city_name text, " +
            "city_code text, " +
            "province_id integer)";
    public static final String CREATE_COUNTY="create table County (" +
            "_id integer primary key autoincrement, " +
            "county_name text, " +
            "county_code text, " +
            "city_id integer)";

    public WeatherCoolOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_PROVINCE);
        db.execSQL(CREATE_CITY);
        db.execSQL(CREATE_COUNTY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}