package com.test.app.fx.hello;

/**
 * Created by zc on 15-6-7.
 */
public class Book {
    private String name;
    private Integer price;
    private String isbn;

    public Book(String name, Integer price, String isbn) {
        this.name = name;
        this.price = price;
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
