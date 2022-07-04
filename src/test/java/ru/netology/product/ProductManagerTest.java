package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductManager;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    Product item1 = new Product(1, "War&Peace", 1_000);
    Product item2 = new Product(2, "Onegin", 1_100);
    Product item3 = new Product(3, "Hamlet", 1_200);


    @Test
    public void shouldAddNewProducts() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts (item1);
        manager.addNewProducts (item2);
        manager.addNewProducts (item3);

        Product [] expected = {item1, item2, item3};
        Product [] actual = manager.getSavedProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewProductsAndRemove() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts (item1);
        manager.addNewProducts (item2);
        manager.addNewProducts (item3);
        manager.removeProductById(item2.getId());

        Product [] expected = {item1, item3};
        Product [] actual = manager.getSavedProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfNoProductsInArray () {
        ProductManager manager = new ProductManager(new ProductRepository());

        Product [] expected = {};
        Product [] actual = manager.searchBy("Onegin");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfOneProductInArrayAndOneItemIsPresent() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);

        Product [] expected = {item1};
        Product [] actual = manager.searchBy("War&Peace");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfOneProductInArrayAndNoItemIsPresent() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);

        Product [] expected = {};
        Product [] actual = manager.searchBy("Onegin");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfSomeProductsInArrayAndOneItemIsPresent () {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);

        Product [] expected = {item2};
        Product [] actual = manager.searchBy("Onegin");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchedItemByRequestIfSomeProductsInArrayAndSomeItemsArePresent () {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);
        manager.addNewProducts(item2);

        Product [] expected = {item2, item2};
        Product [] actual = manager.searchBy("Onegin");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfSomeProductsInArrayButItemIsNotPresent () {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);

        Product [] expected = {};
        Product [] actual = manager.searchBy("Viy");

        Assertions.assertArrayEquals(expected, actual);
    }
}