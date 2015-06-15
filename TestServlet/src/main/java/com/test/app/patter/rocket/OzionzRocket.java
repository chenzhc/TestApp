package com.test.app.patter.rocket;

/**
 * Created by zc on 2015/6/15.
 */
public class OzionzRocket extends PhysicalRocket implements RocketSim {

    public OzionzRocket(double burnArea,
                        double burnRate,
                        double fuelMass,
                        double totalMass) {
        super(burnArea, burnRate, fuelMass, totalMass);
    }

    @Override
    public double getMass() {
        return 0;
    }

    @Override
    public double getThrust() {
        return 0;
    }

    @Override
    public void setSimTime(double t) {

    }
}
