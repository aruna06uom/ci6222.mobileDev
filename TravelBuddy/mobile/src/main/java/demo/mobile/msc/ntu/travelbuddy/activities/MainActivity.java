package demo.mobile.msc.ntu.travelbuddy.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import demo.mobile.msc.ntu.travelbuddy.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void addNewTrip(View view) {

        // Do something in response to button
        Intent intent = new Intent(this, AddTripActivity.class);
        startActivity(intent);
    }

    public void viewComingTrips(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ViewTripsActivity.class);
        startActivity(intent);
    }

    public void viewPastTrips(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ViewTripsActivity.class);
        startActivity(intent);
    }

    public void viewTripsTabs(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ViewTripsTabs.class);
        startActivity(intent);
    }
}
