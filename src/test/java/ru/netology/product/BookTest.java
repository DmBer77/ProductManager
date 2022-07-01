package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookTest {

    @Test
    public void shouldFindItemByNameOfBookIfPresent() {
        Book book = new Book(1, "War&Peace", 1_000, "L.N.Tolstoy");

        boolean expected = true;
        boolean actual = book.matches(book, "War&Peace");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindItemByAuthorIfPresent() {
        Book book = new Book(3, "Hamlet", 1_200, "W. Shakespeare");

        boolean expected = true;
        boolean actual = book.matches(book, "W. Shakespeare");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindItemByTextIfNoOneItemPresent() {
        Book book = new Book(3, "Hamlet", 1_200, "W. Shakespeare");

        boolean expected = false;
        boolean actual = book.matches(book, "F.M. Dostoyevskiy");

        Assertions.assertEquals(expected, actual);
    }
}
