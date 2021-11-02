package com.pb.ssn.hw5;

public class Reader {
    private String readerName;
    private String libraryCardNumber;
    private String faculty;
    private String birthday;
    private String phoneNumber;

    public Reader() {

    }

    public Reader(String readerName, String libraryCardNumber, String faculty, String birthday, String phoneNumber) {
        this.readerName = readerName;
        this.libraryCardNumber = libraryCardNumber;
        this.faculty = faculty;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public void setLibraryCardNumber(String libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInfo() {
        return readerName + "; " + libraryCardNumber + "; " + faculty + "; " + birthday + "; " + phoneNumber;
    }

    public void takeBook(int countBooks) {
        System.out.println(readerName + " взял книг в кол-ве " + countBooks + " шт.");
    }

    public void takeBook(String... nameBooks) {
        System.out.print(readerName + " взял книги: ");

        for (String nameBook: nameBooks) {
            System.out.print(nameBook + ", ");
        }
        System.out.println("");
    }

    public void takeBook(Book... books) {
        System.out.print(readerName + " взял книги: ");

        for (Book book: books) {
            System.out.print(book.getInfo() + ", ");
        }
        System.out.println("");
    }

    public void returnBook(int countBooks) {
        System.out.println(readerName + " вернул книг в кол-ве " + countBooks + " шт.");
    }

    public void returnBook(String... nameBooks) {
        System.out.print(readerName + " вернул книги: ");

        for (String nameBook: nameBooks) {
            System.out.print(nameBook + ", ");
        }
        System.out.println("");
    }

    public void returnBook(Book... books) {
        System.out.print(readerName + " вернул книги: ");

        for (Book book: books) {
            System.out.print(book.getInfo());
        }
        System.out.println("");
    }
}
