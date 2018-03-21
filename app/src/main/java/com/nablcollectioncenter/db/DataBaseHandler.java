package com.nablcollectioncenter.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.nablcollectioncenter.pojo.AccommodationPojo;
import com.nablcollectioncenter.pojo.GeneralInfoPojo;

/**
 * Created by raj on 3/21/2018.
 */

public class DataBaseHandler extends SQLiteOpenHelper {

    private static DataBaseHandler sInstance;

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "NABLCollectionCenter";

    private static final String TABLE_GENERALINFO = "GeneralInfo";
    private static final String TABLE_ACCOMMODATION = "Accommodation";

    // General table column name

    private static final String KEY_ID = "id";
    private static final String KEY_CENTER_NAME = "Center_name";
    private static final String KEY_CollectionCenter = "Collection_center";
    private static final String KEY_Size_of_premises = "Size_of_premises";
    private static final String KEY_Average_Number_of_patients  = "Average_Number_of_patients";
    private static final String KEY_requirement_of_the_workload = "requirement_of_the_workload";
    private static final String KEY_Reception_and_waiting_area  = "Reception_and_waiting_area";
    private static final String KEY_Hand_washing_facility  = "Hand_washing_facility";
    private static final String KEY_Clean_toilet_facility = "Clean_toilet_facility";
    private static final String KEY_Provision_of_privacy  = "Provision_of_privacy";
    private static final String KEY_Hours_of_operation  = "Hours_of_operation";

    // Accommodation table column name

    private static final String KEY_adequately_lit_and_clean = "adequately_lit_and_clean";
    private static final String KEY_humidity_and_temperature_suitable = "humidity_and_temperature_suitable";
    private static final String KEY_cleaning_policies_available  = "cleaning_policies_available";
    private static final String KEY_adequately_ventilated_and_prevented  = "adequately_ventilated_and_prevented";
    private static final String KEY_adequate_space_separation  = "adequate_space_separation";



    public DataBaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public static synchronized DataBaseHandler getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        if (sInstance == null) {
            sInstance = new DataBaseHandler(context.getApplicationContext());
        }
        return sInstance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_GENERALINFO_TABLE);
        db.execSQL(CREATE_ACCOMMODATION_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GENERALINFO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOMMODATION);
    }

    String CREATE_GENERALINFO_TABLE = "CREATE TABLE "
            + TABLE_GENERALINFO + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_CENTER_NAME + " TEXT,"
            + KEY_CollectionCenter + " TEXT,"
            + KEY_Size_of_premises + " TEXT,"
            + KEY_Average_Number_of_patients + " TEXT,"
            + KEY_requirement_of_the_workload + " TEXT,"
            + KEY_Reception_and_waiting_area + " TEXT,"
            + KEY_Hand_washing_facility + " TEXT,"
            + KEY_Clean_toilet_facility + " TEXT,"
            + KEY_Provision_of_privacy + " TEXT,"
            + KEY_Hours_of_operation + " TEXT" + ")";

    String CREATE_ACCOMMODATION_TABLE = "CREATE TABLE "
            + TABLE_ACCOMMODATION + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_CENTER_NAME + " TEXT,"
            + KEY_adequately_lit_and_clean + " TEXT,"
            + KEY_humidity_and_temperature_suitable + " TEXT,"
            + KEY_cleaning_policies_available + " TEXT,"
            + KEY_adequately_ventilated_and_prevented + " TEXT,"
            + KEY_adequate_space_separation + " TEXT" + ")";

    public boolean INSERT_GENERALINFO(GeneralInfoPojo pojo){

        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CENTER_NAME, pojo.getCenter_name());
        values.put(KEY_CollectionCenter, pojo.getCollection_center());
        values.put(KEY_Size_of_premises, pojo.getSize_of_premises());
        values.put(KEY_Average_Number_of_patients, pojo.getAverage_Number_of_patients());
        values.put(KEY_requirement_of_the_workload, pojo.getRequirement_of_the_workload());
        values.put(KEY_Reception_and_waiting_area, pojo.getReception_and_waiting_area());
        values.put(KEY_Hand_washing_facility, pojo.getHand_washing_facility());
        values.put(KEY_Clean_toilet_facility, pojo.getClean_toilet_facility());
        values.put(KEY_Provision_of_privacy, pojo.getProvision_of_privacy());
        values.put(KEY_Hours_of_operation, pojo.getHours_of_operation());

        database.insert(TABLE_GENERALINFO,null,values);

        return true;
    }

    public boolean INSERT_ACCOMMODATION(AccommodationPojo pojo){

        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CENTER_NAME,pojo.getCenter_name());
        values.put(KEY_adequately_lit_and_clean,pojo.getAdequately_lit_and_clean());
        values.put(KEY_humidity_and_temperature_suitable,pojo.getHumidity_and_temperature_suitable());
        values.put(KEY_cleaning_policies_available,pojo.getCleaning_policies_available());
        values.put(KEY_adequately_ventilated_and_prevented,pojo.getAdequately_ventilated_and_prevented());
        values.put(KEY_adequate_space_separation,pojo.getAdequate_space_separation());

        database.insert(TABLE_ACCOMMODATION,null,values);

        return true;
    }

    public GeneralInfoPojo getGeneralInfoPojo(String center_name){
        GeneralInfoPojo pojo = null;
        SQLiteDatabase sqliteDB = getReadableDatabase();

        Cursor cursor = sqliteDB.rawQuery("SELECT * FROM " + TABLE_GENERALINFO + " where " + KEY_CENTER_NAME + " ='" + center_name + "'", null);

         if (cursor != null){
          if (cursor.getCount() > 0){
              cursor.moveToFirst();
              pojo = new GeneralInfoPojo();
              pojo.setCenter_name(cursor.getString(cursor.getColumnIndex(KEY_CENTER_NAME)));
              pojo.setCollection_center(cursor.getString(cursor.getColumnIndex(KEY_CollectionCenter)));
              pojo.setSize_of_premises(cursor.getString(cursor.getColumnIndex(KEY_Size_of_premises)));
              pojo.setAverage_Number_of_patients(cursor.getString(cursor.getColumnIndex(KEY_Average_Number_of_patients)));
              pojo.setRequirement_of_the_workload(cursor.getString(cursor.getColumnIndex(KEY_requirement_of_the_workload)));
              pojo.setReception_and_waiting_area(cursor.getString(cursor.getColumnIndex(KEY_Reception_and_waiting_area)));
              pojo.setHand_washing_facility(cursor.getString(cursor.getColumnIndex(KEY_Hand_washing_facility)));
              pojo.setClean_toilet_facility(cursor.getString(cursor.getColumnIndex(KEY_Clean_toilet_facility)));
              pojo.setProvision_of_privacy(cursor.getString(cursor.getColumnIndex(KEY_Provision_of_privacy)));
              pojo.setHours_of_operation(cursor.getString(cursor.getColumnIndex(KEY_Hours_of_operation)));
          }
         }
        cursor.close();
        return pojo;
    }

}
