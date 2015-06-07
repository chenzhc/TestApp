package com.test.app.fx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Created by zc on 15-6-7.
 */
public class CleanupListener {
    public static IntegerProperty counter = new SimpleIntegerProperty(100);

    public static void main(String[] args){
        ChangeListener<Number> listener = CleanupListener::changed;
        counter.addListener(listener);

        counter.set(200);

        counter.removeListener(listener);

        counter.set(300);

    }

    public static void changed(ObservableValue<? extends Number> prop,
                               Number oldValue,
                               Number newvalue) {
        System.out.println("Counter chaned: old = " + oldValue
                + ", new = " + newvalue );
    }
}
