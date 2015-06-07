package com.test.app.fx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by zc on 15-6-7.
 */
public class BidirectionBinding {

    public static void main(String[] args){
        IntegerProperty x = new SimpleIntegerProperty(1);
        IntegerProperty y = new SimpleIntegerProperty(2);
        IntegerProperty z = new SimpleIntegerProperty(3);

        System.out.println("Before binding: " );
        System.out.println("x="+x.get() + ", y="+y.get()+",z="+z.get());

        x.bindBidirectional(y);
        System.out.println("After binding: " );
        System.out.println("x="+x.get() + ", y="+y.get()+",z="+z.get());

        x.bindBidirectional(z);
        System.out.println("After binding: " );
        System.out.println("x="+x.get() + ", y="+y.get()+",z="+z.get());

        z.set(19);
        System.out.println("After binding: " );
        System.out.println("x="+x.get() + ", y="+y.get()+",z="+z.get());

        x.unbindBidirectional(y);
        x.unbindBidirectional(z);
        x.set(100);
        y.set(200);
        z.set(300);
        System.out.println("After binding: " );
        System.out.println("x="+x.get() + ", y="+y.get()+",z="+z.get());

    }
}
