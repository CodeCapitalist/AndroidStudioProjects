package com.example.cphillips.apptwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        TextView myText = (TextView)findViewById(R.id.displayText);
        Intent intent = getIntent();
        myText.setText( intent.getStringExtra(EXTRA_MESSAGE));
    }
}
