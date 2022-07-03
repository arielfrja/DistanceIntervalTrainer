package com.arielfaridja.distanceintervaltrainer.entities;

import java.io.Serializable;

public class Interval implements Serializable {
    float distance;
    int color;

    public Interval(float distance, int color, String name) {
        this.distance = distance;
        this.color = color;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    String name;

    public void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
