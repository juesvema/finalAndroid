package com.example.user.afinal.Views;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.user.afinal.Domain.Event;
import com.example.user.afinal.Model.EventDetailViewModel;
import com.example.user.afinal.R;
import com.example.user.afinal.databinding.EventDetailActivityBinding;

/**
 * Created by User on 28/10/2017.
 */

public class EventDetailActivity extends AppCompatActivity {


    private static final String EXTRA_EVENT = "EXTRA_EVENT";

    private EventDetailActivityBinding eventDetailActivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventDetailActivityBinding =
                DataBindingUtil.setContentView(this, R.layout.event_detail_activity);

        setSupportActionBar(eventDetailActivityBinding.toolbar);
        displayHomeAsUpEnabled();
        getExtrasFromIntent();
    }

    public static Intent launchDetail(Context context, Event event) {
        Intent intent = new Intent(context, EventDetailActivity.class);
        intent.putExtra(EXTRA_EVENT, event);
        return intent;
    }

    private void displayHomeAsUpEnabled() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void getExtrasFromIntent() {
        Event event = (Event) getIntent().getSerializableExtra(EXTRA_EVENT);
        EventDetailViewModel eventDetailViewModel = new EventDetailViewModel(event);
        eventDetailActivityBinding.setEventDetailViewModel(eventDetailViewModel);
    }
}
