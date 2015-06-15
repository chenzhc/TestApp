package com.test.app.patter.rocket;

/**
 * Created by zc on 2015/6/15.
 */
public class PhysicalRocket {
    public PhysicalRocket(double burnArea,
                          double burnRate,
                          double fuelMass,
                          double totalMass) {

    }

    public double getBurnTime(){
        return 0;
    }

    public double getMass(double t){
        return t;
    }

    public double getThurst(double t){
        return t;
    }
}
