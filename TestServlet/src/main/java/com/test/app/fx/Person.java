package com.test.app.fx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by zc on 15-6-7.
 */
public class Person {
    private StringProperty aliasName;
    private StringProperty firstName;
    private StringProperty lastName;
    private ObservableList<Person> employees = FXCollections.observableArrayList();

    public String getAliasName() {
        return aliasName.get();
    }

    public StringProperty aliasNameProperty() {
        if(aliasName==null){
            aliasName = new SimpleStringProperty();
        }
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        aliasNameProperty().set(aliasName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        if(firstName==null){
            firstName = new SimpleStringProperty();
        }
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstNameProperty().set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        if(lastName == null){
            lastName = new SimpleStringProperty();
        }
        return lastName;
    }

    public void setLastName(String lastName) {
        lastNameProperty().set(lastName);
    }

    public ObservableList<Person> getEmployees() {
        return employees;
    }

    public void setEmployees(ObservableList<Person> employees) {
        this.employees = employees;
    }

    public Person(String aliasName,
                  String firstName,
                  String lastName) {
        setAliasName(aliasName);
        setFirstName(firstName);
        setLastName(lastName);
    }
}
