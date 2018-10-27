package demo.mobile.msc.ntu.travelbuddy.activities;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import demo.mobile.msc.ntu.travelbuddy.R;

public class ViewTripsTabs extends TabActivity {


    private static final String COMING_TRIPS = "coming_trips";
    private static final String PAST_TRIPS = "past_trips";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_trips_tabs);

        TabHost tabHost = getTabHost();

        TabSpec comingTripsSpec = tabHost.newTabSpec(COMING_TRIPS);
        comingTripsSpec.setIndicator(COMING_TRIPS, getResources().getDrawable(R.drawable.sunset_32));
        Intent comingIntent = new Intent(this, ComingTripsActivity.class);
        comingTripsSpec.setContent(comingIntent);

        TabSpec pastTripsSpec = tabHost.newTabSpec(PAST_TRIPS);
        pastTripsSpec.setIndicator(PAST_TRIPS, getResources().getDrawable(R.drawable.sunset_32));
        Intent pastIntent = new Intent(this, PastTripsActivity.class);
        pastTripsSpec.setContent(pastIntent);

        tabHost.addTab(comingTripsSpec);
        tabHost.addTab(pastTripsSpec);
    }

}
