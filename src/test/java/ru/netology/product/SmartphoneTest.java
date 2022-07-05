package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SmartphoneTest {

    @Test
    public void shouldFindItemByNameOfSmartphoneIfPresent() {
        Smartphone smartphone = new Smartphone(4, "J7", 22_000, "Samsung");

        boolean expected = true;
        boolean actual = smartphone.matches(smartphone, "J7");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindItemByManufacturerIfPresent() {
        Smartphone smartphone = new Smartphone(5, "12", 50_000, "Apple");

        boolean expected = true;
        boolean actual = smartphone.matches(smartphone, "Apple");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindItemByTextIfNoOneItemPresent() {
        Smartphone smartphone = new Smartphone(5, "12", 50_000, "Apple");

        boolean expected = false;
        boolean actual = smartphone.matches(smartphone, "Nokia");

        Assertions.assertEquals(expected, actual);
    }
}