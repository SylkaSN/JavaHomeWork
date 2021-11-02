package com.pb.ssn.hw5;

public class Library {
    public static void main(String[] args) {
        Reader[] readers = new Reader[3];
        Book[] books = new Book[4];

        readers[0] = new Reader("Иванов И.И.", "А00001", "Радиоэлектроника"
                                , "10.04.2004", "+380675436790");
        readers[1] = new Reader("Петров П.П.", "А00002", "Элетротехника"
                , "15.08.2002", "+380678641287");
        readers[2] = new Reader("Сидоров С.С.", "А00003", "Физмат"
                , "23.02.2001", "+380671497532");

        books[0] = new Book("Приключение", "Васечкин В.В.", 2000);
        books[1] = new Book("Словарь", "Даль В.И.", 1980);
        books[2] = new Book("Энциклопедия", "Ефрон И.А.", 1970);
        books[3] = new Book("Детектив", "Чейз Д.Х.", 1990);

        System.out.println("---===>>> Список книг");
        for (Book b: books) {
            System.out.println(b.getInfo());
        }
        System.out.println(" ");

        System.out.println("---===>>> Список читателей");
        for (Reader r: readers) {
            System.out.println(r.getInfo());
        }
        System.out.println(" ");

        System.out.println("---===>>> Перегрузка метода takeBook()");
        readers[0].takeBook(4);
        readers[1].takeBook(books[0].getName(), books[1].getName());
        readers[2].takeBook(books[2], books[3]);
        System.out.println(" ");

        System.out.println("---===>>> Перегрузка метода returnBook()");
        readers[0].returnBook(4);
        readers[1].returnBook(books[0].getName(), books[1].getName());
        readers[2].returnBook(books[2], books[3]);
    }

}
