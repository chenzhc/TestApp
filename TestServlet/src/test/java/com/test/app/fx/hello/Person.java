package com.test.app.fx.hello;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Created by zc on 15-6-7.
 */
public class Person {
    private ObjectProperty<Address> addr =
            new SimpleObjectProperty<>(new Address());

    public Address getAddr() {
        return addr.get();
    }

    public ObjectProperty<Address> addrProperty() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr.set(addr);
    }
}
