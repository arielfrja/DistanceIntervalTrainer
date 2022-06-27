package com.arielfaridja.distanceintervaltrainer.UI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arielfaridja.distanceintervaltrainer.R;
import com.arielfaridja.distanceintervaltrainer.adapters.WorkoutsListAdapter;
import com.arielfaridja.distanceintervaltrainer.sampledata.Sampledata;

public class MainActivity extends AppCompatActivity {
    Sampledata data = new Sampledata();
    WorkoutsListAdapter adapter = new WorkoutsListAdapter(data.workouts);
    RecyclerView workoutList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workoutList = findViewById(R.id.workoutsList);
        workoutList.setAdapter(adapter);
        workoutList.setLayoutManager(new LinearLayoutManager(this));

    }
}