package com.test.app.fx.hello;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by zc on 15-6-7.
 */
public class Address {
    private StringProperty zip = new SimpleStringProperty("36106");

    public String getZip() {
        return zip.get();
    }

    public StringProperty zipProperty() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip.set(zip);
    }
}
