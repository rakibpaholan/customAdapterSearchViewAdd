package com.example.customadaptersearchview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NewActivities extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_activities);

        ActionBar actionBar = getSupportActionBar();
        textView = (TextView)findViewById(R.id.new_page_id);
        Intent intent = getIntent();

        String myActionBarTitle = intent.getStringExtra("actionBarTitle");
        String mContent = intent.getStringExtra("contentTv");
        actionBar.setTitle(myActionBarTitle);
        textView.setText(mContent);



    }
}