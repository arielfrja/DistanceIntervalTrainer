package com.arielfaridja.distanceintervaltrainer.UI;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.arielfaridja.distanceintervaltrainer.R;
import com.arielfaridja.distanceintervaltrainer.entities.Workout;

public class WorkoutActivity extends AppCompatActivity {
    Workout workout;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        workout = (Workout) getIntent().getSerializableExtra("workout");
        setContentView(R.layout.activity_workout);
        title = findViewById(R.id.workoutActivityTitle);
        title.setText(workout.getName());
    }
}