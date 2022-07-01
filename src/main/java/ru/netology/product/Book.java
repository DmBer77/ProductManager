package ru.netology.product;

public class Book extends Product {
    protected static String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        Book.author = author;
    }

    public static String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        Book.author = author;
    }
    @Override
    public boolean matches(Product product, String search) {
        if (super.matches(product, search)) {
            return true;
        }
        return getAuthor().contains(search);
    }
}
