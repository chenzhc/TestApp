package com.test.app.fx;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by zc on 15-6-7.
 */
public class BindingTest {

    public static void main(String[] args){
        IntegerProperty x = new SimpleIntegerProperty(100);
        IntegerProperty y = new SimpleIntegerProperty(200);

        NumberBinding sum = x.add(y);

        System.out.println("After creating sum");
        System.out.println("sum.isValid(): " + sum.isValid());

        int value = sum.intValue();

        System.out.println("\nAfter requesting value: ");
        System.out.println("sum.isValid(): " + sum.isValid());
        System.out.println("sum = " + value);

        x.set(250);

        System.out.println("\nAfter changing x");
        System.out.println("sum.isValid(): " + sum.isValid());

        value = sum.intValue();

        System.out.println("\nAfter requesting value");
        System.out.println("sum.isValid(): " + sum.isValid());
        System.out.println("sum = " + value);

    }
}
