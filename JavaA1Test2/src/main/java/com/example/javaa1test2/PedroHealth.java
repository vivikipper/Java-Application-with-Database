package com.example.javaa1test2;

public class PedroHealth {
    private String weekName;
    private int waterCount;

    public PedroHealth(String weekName, int waterCount) {
        this.weekName = weekName;
        this.waterCount = waterCount;
    }

    public String getWeekName() {
        return weekName;
    }

    public void setWeekName(String weekName) {
        this.weekName = weekName;
    }

    public int getWaterCount() {
        return waterCount;
    }

    public void setWaterCount(int waterCount) {
        this.waterCount = waterCount;
    }
}