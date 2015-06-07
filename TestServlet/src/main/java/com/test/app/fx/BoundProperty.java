package com.test.app.fx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by zc on 15-6-7.
 */
public class BoundProperty {

    public static void main(String[] args){
        IntegerProperty x = new SimpleIntegerProperty(10);
        IntegerProperty y = new SimpleIntegerProperty(20);
        IntegerProperty z = new SimpleIntegerProperty(60);
        z.bind(x.add(y));

        System.out.println("After binding z: Bound = " + z.isBound()
                + ", z = " + z.get());

        x.set(15);
        y.set(19);
        System.out.println("After changing x and y: Bound = " + z.isBound()
                + ", z = " + z.get());

        z.unbind();

        x.set(100);
        y.set(200);
        System.out.println("After unbinding z: Bound = " + z.isBound()
                + ", z = " + z.get());
    }
}
