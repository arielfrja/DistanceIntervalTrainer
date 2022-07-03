package com.arielfaridja.distanceintervaltrainer.UI;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arielfaridja.distanceintervaltrainer.R;
import com.arielfaridja.distanceintervaltrainer.adapters.WorkoutViewAdapter;
import com.arielfaridja.distanceintervaltrainer.entities.Workout;

public class WorkoutActivity extends AppCompatActivity {
    Workout workout;
    TextView title;
    RecyclerView workoutLoopsList;
    WorkoutViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        workout = (Workout) getIntent().getSerializableExtra("workout");
        adapter = new WorkoutViewAdapter(workout);
        setContentView(R.layout.activity_workout);
        title = findViewById(R.id.workoutActivityTitle);
        workoutLoopsList = findViewById(R.id.workoutLoopsList);
        title.setText(workout.getName());
        workoutLoopsList.setAdapter(adapter);
        workoutLoopsList.setLayoutManager(new LinearLayoutManager(this));

    }
}