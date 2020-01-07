package com.example.bearnapp;


import android.graphics.RectF;

public class RingO {
    private int progress;
    private String name;
    private String value;
    private RectF rectFRing;

    public RingO(int p, String value, String name) {
        this.progress = p;
        this.name = name;
        this.value = value;

    }

    public RingO() {
    }


    public String getName() {
        return name;
    }

    public RectF getRectFRing() {
        return rectFRing;
    }

    public void setRectFRing(RectF rectFRing) {
        this.rectFRing = rectFRing;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
