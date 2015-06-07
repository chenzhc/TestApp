package com.test.app.fx;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by zc on 15-6-7.
 */
public class User {
    private final static String USERNAME_PROP_NAME = "userName";
    private final ReadOnlyStringWrapper userName;
    private final static String PASSWORD_PROP_NAME = "password";
    private StringProperty password;

    public User() {
        this.userName = new ReadOnlyStringWrapper(this,
                USERNAME_PROP_NAME,System.getProperty("user.name"));
        this.password = new SimpleStringProperty(this,PASSWORD_PROP_NAME);
    }

    public final String getUserName() {
        return userName.get();
    }

    public ReadOnlyStringWrapper userNameProperty() {
        return userName;
    }

    public final void setUserName(String userName) {
        this.userName.set(userName);
    }

    public final String getPassword() {
        return password.get();
    }

    public final StringProperty passwordProperty() {
        return password;
    }

    public final void setPassword(String password) {
        this.password.set(password);
    }
}
