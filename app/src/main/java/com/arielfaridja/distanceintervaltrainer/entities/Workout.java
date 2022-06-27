package com.arielfaridja.distanceintervaltrainer.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Workout implements Serializable {
    float totalDistance;
    private String name;
    private ArrayList<Loop> loops;

    public Workout() {
        loops = new ArrayList<>();
    }

    public Workout(String name) {
        loops = new ArrayList<>();
        this.name = name;
    }

    public float totalDistance() {
        totalDistance = 0;
        for (Loop loop : getLoops()
        ) {
            if (loop.totalDistance == 0)
                loop.calculateTotalDistance();
            totalDistance += loop.totalDistance;
        }
        return totalDistance;
    }

    public int totalIntervals() {
        int sum = 0;
        for (Loop loop : getLoops()
        ) {
            sum += loop.getIntervals().size();

        }
        return sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Loop> getLoops() {
        return loops;
    }

    public void setLoops(ArrayList<Loop> loops) {
        this.loops = loops;
    }
}
