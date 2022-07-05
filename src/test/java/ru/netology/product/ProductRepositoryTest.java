package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {

    Product item1 = new Book(1, "War&Peace", 1_000, "L.N.Tolstoy");
    Product item2 = new Book(2, "Onegin", 1_100, "A.S.Pushkin");
    Product item3 = new Book(3, "Hamlet", 1_200, "W. Shakespeare");
    Product item4 = new Smartphone(4, "J7", 22_000, "Samsung");
    Product item5 = new Smartphone(5, "12", 50_000, "Apple");

    @Test
    public void shouldTryToRemoveProductFromArrayIfItemIsPresent () {
        ProductRepository repository = new ProductRepository();
        repository.addNewProducts(item1);
        repository.addNewProducts(item2);
        repository.addNewProducts(item3);
        repository.removeProductById(3);

        Product[] expected = {item1, item2};
        Product[] actual = repository.getSavedProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTryToRemoveProductFromArrayIfItemIsNotPresent () {
        ProductRepository repository = new ProductRepository();
        repository.addNewProducts(item1);
        repository.addNewProducts(item2);
        repository.addNewProducts(item3);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeProductById(8);
        });
    }
}
