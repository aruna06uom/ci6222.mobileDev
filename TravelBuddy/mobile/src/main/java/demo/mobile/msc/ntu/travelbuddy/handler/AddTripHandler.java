package demo.mobile.msc.ntu.travelbuddy.handler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import demo.mobile.msc.ntu.travelbuddy.entities.Trip;

public class AddTripHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TravelBuddyDB.db";
    public static final String TABLE_TRIP = "TRIP";

    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_TYPE = "TYPE";
    public static final String COLUMN_START_DATE = "START_DATE";
    public static final String COLUMN_END_DATE = "END_DATE";


    public AddTripHandler(
            Context context, SQLiteDatabase.CursorFactory factory)
    {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TRIP_TABLE = "CREATE TABLE " +
                TABLE_TRIP + "("
                + COLUMN_NAME + " TEXT PRIMARY KEY," + COLUMN_TYPE + " TEXT,"
                + COLUMN_START_DATE + " TEXT,"+ COLUMN_END_DATE + " TEXT"+ ")";
        db.execSQL(CREATE_TRIP_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRIP);
        onCreate(db);
    }


    public void addTrip(Trip trip) {

        try (SQLiteDatabase db = this.getWritableDatabase();){
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, trip.getName());
            values.put(COLUMN_TYPE, trip.getType());
            values.put(COLUMN_START_DATE, trip.getStartDate());
            values.put(COLUMN_END_DATE, trip.getEndDate());
            db.insert(TABLE_TRIP, null, values);
            Log.i("addTrip", "Trip :" + trip.getName() + " added successfully");
        } catch (Exception e) {
            Log.e("addTrip", "Error while adding trip");
        }
    }

    public Trip getTrip(String tripName) {

        String query = "SELECT * FROM " + TABLE_TRIP + " WHERE " + COLUMN_NAME + " =  \"" + tripName + "\"";
        Trip trip = new Trip();
        try (SQLiteDatabase db = this.getWritableDatabase()){
            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()) {
                cursor.moveToFirst();
                trip.setName(cursor.getString(1));
                trip.setType(cursor.getString(2));
                trip.setStartDate(cursor.getString(3));
                trip.setEndDate(cursor.getString(4));
                cursor.close();

            } else {
                trip = null;
            }
        } catch (Exception e) {
            Log.e("addTrip", "Error while adding trip");
        }
        return trip;

    }
}
