package br.com.fatecudos.herdeirinho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        Bundle extras = getIntent().getExtras();
        Event event = (Event)extras.getSerializable("event");
        setTitle(R.string.event_details_activity_title);

        final TextView labelEventNameValue = (TextView)findViewById(R.id.labelEventNameValue);
        final TextView labelEventDateValue = (TextView)findViewById(R.id.labelEventDateValue);
        final TextView labelEventLocalValue = (TextView)findViewById(R.id.labelEventLocalValue);
        final TextView labelEventDescriptionValue = (TextView)findViewById(R.id.labelEventDescriptionValue);

        labelEventNameValue.setText(event.getName());
        labelEventDateValue.setText(Utils.dateToString(event.getDate()));
        labelEventLocalValue.setText(event.getLocal());
        labelEventDescriptionValue.setText(event.getDescription());
    }
}
