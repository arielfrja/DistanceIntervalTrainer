package com.arielfaridja.distanceintervaltrainer.entities;

import java.io.Serializable;

public class Interval implements Serializable {
    float distnace;
    int color;
    String name;

    public Interval(float distnace, int color, String name) {
        this.distnace = distnace;
        this.color = color;
        this.name = name;
    }

    public float getDistnace() {
        return distnace;
    }

    public void setDistnace(float distnace) {
        this.distnace = distnace;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
