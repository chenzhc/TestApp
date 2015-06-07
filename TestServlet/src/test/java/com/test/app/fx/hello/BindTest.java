package com.test.app.fx.hello;

import javafx.beans.binding.*;
import javafx.beans.property.*;
import javafx.scene.layout.BorderPane;
import org.junit.Test;

import java.nio.DoubleBuffer;
import java.util.Locale;

/**
 * Created by zc on 15-6-7.
 */
public class BindTest {

    @Test
    public void test1(){
        IntegerProperty x = new SimpleIntegerProperty(100);
        IntegerProperty y = new SimpleIntegerProperty(200);
        NumberBinding sum = x.add(y);
        int value = sum.intValue();
        System.out.println(value);

    }

    @Test
    public void test2(){
        IntegerProperty x = new SimpleIntegerProperty(1);
        IntegerProperty y = new SimpleIntegerProperty(2);
        NumberBinding sum = x.add(y);
        int value = sum.intValue();
        System.out.println(value);
    }

    @Test
    public void test3(){
        IntegerProperty x = new SimpleIntegerProperty(1);
        IntegerProperty y = new SimpleIntegerProperty(2);
        IntegerBinding sum = (IntegerBinding) x.add(y);

        int value = sum.get();
        System.out.println(value);
    }

    @Test
    public void test4(){
        DoubleProperty radius = new SimpleDoubleProperty(7.0);

        DoubleBinding area = radius.multiply(radius).multiply(Math.PI);

        System.out.println("Radius = " + radius.get()
                + ", Area = " + area.get());

        radius.set(14.0);
        System.out.println("Radius = " + radius.get()
                + ", Area = " + area.get());

        DoubleProperty area2 = new SimpleDoubleProperty();
        area2.bind(radius.multiply(radius).multiply(Math.PI));
        System.out.println("Radius = " + radius.get()
                + ", Area2 = " + area2.get());
    }

    @Test
    public void test5(){
        DoubleProperty radius = new SimpleDoubleProperty(7.0);
        DoubleProperty area = new SimpleDoubleProperty(0);
        StringProperty initStr = new SimpleStringProperty("Radius = ");

        area.bind(radius.multiply(radius).multiply(Math.PI));

        StringExpression desc = initStr.concat(radius.asString())
                .concat(", Area = ")
                .concat(area.asString(Locale.US,"%.2f"));

        System.out.println(desc.getValue());

        radius.set(14.0);
        System.out.println(desc.getValue());

    }

    @Test
    public void test6(){
        Book b1 = new Book("J1",90,"1234567890");
        Book b2 = new Book("J2",80,"012345679");

        ObjectProperty<Book> book1 = new SimpleObjectProperty<>(b1);
        ObjectProperty<Book> book2 = new SimpleObjectProperty<>(b2);

        BooleanBinding isEqual = book1.isEqualTo(book2);
        System.out.println(isEqual.get());

        book2.set(b1);
        System.out.println(isEqual.get());

    }

    @Test
    public void test7(){
        IntegerProperty x = new SimpleIntegerProperty(1);
        IntegerProperty y = new SimpleIntegerProperty(2);
        IntegerProperty z = new SimpleIntegerProperty(3);

        BooleanExpression condition = x.greaterThan(y).and(y.isEqualTo(z));

        System.out.println(condition.get());

        x.set(3);
        System.out.println(condition.get());
    }

    @Test
    public void test8(){
        IntegerProperty num = new SimpleIntegerProperty(10);
        StringBinding desc = new When(num.divide(2).multiply(2).isEqualTo(num))
                .then("even")
                .otherwise("odd");

        System.out.println(num.get() + " is "+ desc.get());
        num.set(19);
        System.out.println(num.get() + " is " + desc.get());

    }

    @Test
    public void test9(){
        DoubleProperty radius = new SimpleDoubleProperty(7.0);
        DoubleProperty area = new SimpleDoubleProperty(0.0);

        area.bind(Bindings.multiply(Bindings.multiply(radius,radius),Math.PI));

        StringExpression desc = Bindings.format(Locale.US,
                "radius = %.2f, Area = %.2f",radius,area);

        System.out.println(desc.get());

        radius.set(14.0);
        System.out.println(desc.getValue());

    }

    @Test
    public void test10(){
        ObjectProperty<Person> p = new SimpleObjectProperty<>(new Person());

        StringBinding zipBinding = Bindings.selectString(p,"addr","zip");
        System.out.println(zipBinding.get());


        p.get().addrProperty().get().setZip("35217");
        System.out.println(zipBinding.get());

        StringBinding stateBinding = Bindings.selectString(p,"addr","state");
        System.out.println(stateBinding.get());
    }
}
