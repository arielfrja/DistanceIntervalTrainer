package com.arielfaridja.distanceintervaltrainer.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Loop implements Serializable {
    int index;
    float totalDistance = 0;
    private int times;
    private ArrayList<Interval> intervals;


    public Loop() {
        intervals = new ArrayList<>();
    }

    float calculateTotalDistance() {
        totalDistance = 0;
        for (Interval interval :
                getIntervals()) {
            totalDistance += interval.distnace;
        }
        return totalDistance;
    }

    public ArrayList<Interval> getIntervals() {
        return intervals;
    }

    public void setIntervals(ArrayList<Interval> intervals) {
        this.intervals = intervals;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
