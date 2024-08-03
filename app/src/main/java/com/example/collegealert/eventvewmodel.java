package com.example.collegealertapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.collegealertapp.Event;

import java.util.ArrayList;
import java.util.List;

public class EventViewModel extends ViewModel {
    private final MutableLiveData<List<Event>> events = new MutableLiveData<>();

    public EventViewModel() {
        // Dummy data for now
        List<Event> eventList = new ArrayList<>();
        eventList.add(new Event("Orientation", "Welcome to the new students", "2023-09-01"));
        eventList.add(new Event("Sports Day", "Annual sports day event", "2023-09-15"));
        events.setValue(eventList);
    }

    public LiveData<List<Event>> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        List<Event> currentEvents = events.getValue();
        if (currentEvents != null) {
            currentEvents.add(event);
            events.setValue(currentEvents);
        }
    }
}
