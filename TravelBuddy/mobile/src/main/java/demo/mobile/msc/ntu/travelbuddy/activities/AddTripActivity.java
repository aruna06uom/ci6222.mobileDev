package demo.mobile.msc.ntu.travelbuddy.activities;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.autofill.AutofillId;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import demo.mobile.msc.ntu.travelbuddy.R;
import demo.mobile.msc.ntu.travelbuddy.entities.Trip;
import demo.mobile.msc.ntu.travelbuddy.handler.AddTripHandler;

public class AddTripActivity extends AppCompatActivity {

    EditText tripName;
    DatePickerDialog datePickerDialog;
    EditText startDate;
    EditText endDate;
    Spinner tripType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);

        tripName = (EditText) findViewById(R.id.tripName);
        startDate = (EditText) findViewById(R.id.startdate);
        endDate = (EditText) findViewById(R.id.enddate);
        tripType = (Spinner) findViewById(R.id.tripType);

    }

    public void onStartDateClick(View v) {

        startDate = (EditText) findViewById(R.id.startdate);
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(AddTripActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        startDate.setText(dayOfMonth + "/"
                                + (monthOfYear + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }


    public void onEndDateClick(View v) {

        endDate = (EditText) findViewById(R.id.enddate);
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(AddTripActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        endDate.setText(dayOfMonth + "/"
                                + (monthOfYear + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void onAddNewTrip(View view) {

        AddTripHandler dbHandler = new AddTripHandler(this, null);
        Trip trip = new Trip();
        trip.setName(tripName.getText().toString());
        trip.setStartDate(startDate.getText().toString());
        trip.setEndDate(endDate.getText().toString());
        trip.setType(tripType.getSelectedItem().toString());
        dbHandler.addTrip(trip);

        System.out.println(dbHandler.getTrip(tripName.getText().toString()).getName());

    }


}
