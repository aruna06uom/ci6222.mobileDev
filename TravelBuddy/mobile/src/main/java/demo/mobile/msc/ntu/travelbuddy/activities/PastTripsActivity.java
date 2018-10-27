package demo.mobile.msc.ntu.travelbuddy.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import demo.mobile.msc.ntu.travelbuddy.R;

public class PastTripsActivity extends ListActivity {

    private static final String TAG_NAME = "name";
    private static final String TAG_DESCRIPTION = "description";

    ArrayList<HashMap<String, String>> pastTripsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_trips);

        pastTripsList = new ArrayList<>();

        HashMap<String, String> map1 = new HashMap<>();
        map1.put(TAG_NAME, "Malaysia");
        map1.put(TAG_DESCRIPTION, "school trip");
        HashMap<String, String> map2 = new HashMap<>();
        map2.put(TAG_NAME, "Ausi");
        map2.put(TAG_DESCRIPTION, "Family Trip");
        pastTripsList.add(map1);
        pastTripsList.add(map2);

        ListAdapter adapter = new SimpleAdapter(
                PastTripsActivity.this, pastTripsList,
                R.layout.past_trips_view, new String[] { TAG_NAME, TAG_DESCRIPTION},
                new int[] { R.id.pastTripName, R.id.pastTripDes});
        // updating listview
        setListAdapter(adapter);
    }
}
