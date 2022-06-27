package com.arielfaridja.distanceintervaltrainer.sampledata;

import android.graphics.Color;

import com.arielfaridja.distanceintervaltrainer.entities.Interval;
import com.arielfaridja.distanceintervaltrainer.entities.Loop;
import com.arielfaridja.distanceintervaltrainer.entities.Workout;

import java.util.ArrayList;

public class Sampledata {
    public ArrayList<Workout> workouts = new ArrayList<>();

    public Sampledata() {
        workouts.add(new Workout());
        workouts.add(new Workout());
        workouts.get(0).setName("workout 0");
        workouts.get(0).getLoops().add(new Loop());
        workouts.get(0).getLoops().get(0).getIntervals().add(new Interval(0.3f, Color.GREEN, "run"));
        workouts.get(0).getLoops().get(0).getIntervals().add(new Interval(0.2f, Color.RED, "walk"));
        workouts.get(0).getLoops().get(0).setTimes(2);
        workouts.get(0).getLoops().add(new Loop());
        workouts.get(0).getLoops().get(1).getIntervals().add(new Interval(0.7f, Color.GREEN, "run"));
        workouts.get(0).getLoops().get(1).getIntervals().add(new Interval(0.3f, Color.RED, "walk"));
        workouts.get(0).getLoops().get(1).setTimes(4);

        workouts.get(1).setName("workout 1");
        workouts.get(1).getLoops().add(new Loop());
        workouts.get(1).getLoops().get(0).getIntervals().add(new Interval(0.3f, Color.GREEN, "run"));
        workouts.get(1).getLoops().get(0).getIntervals().add(new Interval(0.2f, Color.RED, "walk"));
        workouts.get(1).getLoops().get(0).setTimes(2);
        workouts.get(1).getLoops().add(new Loop());
        workouts.get(1).getLoops().get(1).getIntervals().add(new Interval(0.7f, Color.GREEN, "run"));
        workouts.get(1).getLoops().get(1).getIntervals().add(new Interval(0.3f, Color.RED, "walk"));
        workouts.get(1).getLoops().get(1).setTimes(4);
    }
}
