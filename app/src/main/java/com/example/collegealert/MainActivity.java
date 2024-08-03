package com.example.collegealertapp;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private com.example.collegealertapp.EventViewModel eventViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        eventViewModel = new ViewModelProvider(this).get(com.example.collegealertapp.EventViewModel.class);
        eventViewModel.getEvents().observe(this, events -> {
            com.example.collegealertapp.EventAdapter adapter = new com.example.collegealertapp.EventAdapter(events);
            recyclerView.setAdapter(adapter);
        });
    }
}