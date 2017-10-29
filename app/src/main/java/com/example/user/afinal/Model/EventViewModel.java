package com.example.user.afinal.Model;

import android.content.Context;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;


import com.example.user.afinal.Controller.EventController;
import com.example.user.afinal.Domain.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class EventViewModel extends Observable {

    public ObservableInt eventRecycler;

    private List<Event> eventList;
    private Context context;
    private EventController appController;

    public EventViewModel(@NonNull Context context) {
        this.context = context;
        this.eventList = new ArrayList<>();
        eventRecycler = new ObservableInt(View.GONE);
        eventRecycler.set(View.GONE);


    }

    public void onClickFabLoad(View view) {
        eventRecycler.set(View.GONE);
        fetchEventList();
    }

    public void fetchEventList() {
        eventRecycler.set(View.GONE);
        appController = new EventController(context);
        eventList.clear();
        changeEventDataSet(appController.fillEvents());
        eventRecycler.set(View.VISIBLE);
    }
    public void fetchEventListDate(String fecha) {
        eventRecycler.set(View.GONE);
        appController = new EventController(context);
        eventList.clear();
        changeEventDataSet(appController.filtrarForDate(fecha));
        eventRecycler.set(View.VISIBLE);
    }
    public void fetchEventListType(String tipo) {
        eventRecycler.set(View.GONE);
        eventList.clear();
        appController = new EventController(context);
        changeEventDataSet(appController.filtrarporTipo(tipo));
        eventRecycler.set(View.VISIBLE);
    }


    private void changeEventDataSet(List<Event> events) {
        if (!events.isEmpty())
            eventList.addAll(events);
            System.out.println("lista 1: " + eventList);
        setChanged();
        notifyObservers();
    }

    public List<Event> getEventList() {
        return eventList;
    }

}
