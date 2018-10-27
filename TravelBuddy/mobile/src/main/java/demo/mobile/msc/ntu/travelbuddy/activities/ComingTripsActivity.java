package demo.mobile.msc.ntu.travelbuddy.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import demo.mobile.msc.ntu.travelbuddy.R;

public class ComingTripsActivity extends ListActivity {


    private static final String TAG_NAME = "name";
    private static final String TAG_DESCRIPTION = "description";

    ArrayList<HashMap<String, String>> comingTripsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coming_trips);

        comingTripsList = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> map1 = new HashMap<>();
        map1.put(TAG_NAME, "Nuwaraeliya");
        map1.put(TAG_DESCRIPTION, "school trip");
        HashMap<String, String> map2 = new HashMap<>();
        map2.put(TAG_NAME, "Thailand");
        map2.put(TAG_DESCRIPTION, "Family Trip");
        comingTripsList.add(map1);
        comingTripsList.add(map2);

        ListAdapter adapter = new SimpleAdapter(
                ComingTripsActivity.this, comingTripsList,
                R.layout.coming_trips_view, new String[] { TAG_NAME, TAG_DESCRIPTION},
                new int[] { R.id.comingTripName, R.id.comingTripDes});
        // updating listview
        setListAdapter(adapter);


    }
}
