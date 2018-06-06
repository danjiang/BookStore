package com.danthought.bookstore;

/**
 * Created by danjiang on 2018/6/5.
 */

public class Book {

    private String title;
    private double price;
    private String author;
    private int pages;

    public Book() {

    }

    public Book(String title, double price, String author, int pages) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}


