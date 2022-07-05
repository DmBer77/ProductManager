package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductManager;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    Product item1 = new Book(1, "War&Peace", 1_000, "L.N.Tolstoy");
    Product item2 = new Book(2, "Onegin", 1_100, "A.S.Pushkin");
    Product item3 = new Book(3, "Hamlet", 1_200, "W. Shakespeare");
    Product item4 = new Smartphone(4, "J7", 22_000, "Samsung");
    Product item5 = new Smartphone(5, "12", 50_000, "Apple");


    @Test
    public void shouldAddNewProducts() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);

        Product[] expected = {item1, item2, item3};
        Product[] actual = manager.getSavedProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewProductsAndRemove() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);
        manager.removeProductById(item2.getId());

        Product[] expected = {item1, item3};
        Product[] actual = manager.getSavedProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfNoProductsInArray() {
        ProductManager manager = new ProductManager(new ProductRepository());

        Product[] expected = {};
        Product[] actual = manager.searchBy("Onegin");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfOneProductInArrayAndOneItemIsPresent() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);

        Product[] expected = {item1};
        Product[] actual = manager.searchBy("War&Peace");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfOneProductInArrayAndNoItemIsPresent() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Onegin");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfSomeProductsInArrayAndOneItemIsPresent() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);

        Product[] expected = {item2};
        Product[] actual = manager.searchBy("Onegin");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfSomeProductsInArrayAndSomeItemsArePresent() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);
        manager.addNewProductsWhenMoreThanOneSimilarItemIsPresent(item2);


        Product[] expected = {item2, item2};
        Product[] actual = manager.searchBy("Onegin");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchedItemByRequestIfSomeProductsInArrayButItemIsNotPresent() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Viy");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfProductsInArrayButSearchingBySecondParam_1() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);


        Product[] expected = {item2};
        Product[] actual = manager.searchBy("A.S.Pushkin");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfProductsInArrayButSearchingBySecondParam_2() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item4);
        manager.addNewProducts(item5);


        Product[] expected = {item4};
        Product[] actual = manager.searchBy("J7");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfProductsInArrayButSearchingBySecondParam_3() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item4);
        manager.addNewProducts(item5);


        Product[] expected = {item5};
        Product[] actual = manager.searchBy("Apple");

        Assertions.assertArrayEquals(expected, actual);
    }
}