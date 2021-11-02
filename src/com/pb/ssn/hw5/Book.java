package com.pb.ssn.hw5;

public class Book {
    private String name;
    private String author;
    private int year;

    public Book() {
    }

    public Book(String name, String autor, int year) {
        this.name = name;
        this.author = autor;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getInfo() {
        return "'" + name + "' (" + author + " " + year + ")";
    }
}
