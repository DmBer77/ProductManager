package ru.netology.repository;

import ru.netology.product.Product;
import ru.netology.product.Book;
import ru.netology.product.Smartphone;

public class ProductManager {

    private final ProductRepository repository;

    public ProductManager (ProductRepository repository) {
        this.repository = repository;
    }

    public void addNewProducts (Product productForAdd) {
        repository.addNewProducts(productForAdd);
    }

    public void addNewProductsWhenMoreThanOneSimilarItemIsPresent (Product productForAdd) {
        repository.addNewProductsWhenMoreThanOneSimilarItemIsPresent(productForAdd);
    }

    public void removeProductById (int id) {
        repository.removeProductById(id);
    }

    public Product [] getSavedProducts () {
        return repository.getSavedProducts();
    }

    public Product[] searchBy(String text) {

        Product[] result = new Product [0];
        for (Product product: repository.getSavedProducts()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {

        if (product.getName().contains(search)) {
            return true;
        }
        if (product instanceof Book) {
            if (((Book) product).getAuthor().contains(search)) {
                return true;
            }
        }
        if (product instanceof Smartphone) {
            return ((Smartphone) product).getManufacturer().contains(search);
        }
        return false;
    }
}
