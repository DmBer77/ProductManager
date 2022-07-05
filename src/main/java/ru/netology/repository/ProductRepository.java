package ru.netology.repository;

import ru.netology.product.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void addNewProducts(Product productForAdd) {
        Product draft_1 = findById(productForAdd.getId());
        if (draft_1 != null) {
            throw new AlreadyExistsException(
                    "Element with id: " + productForAdd.getId() + " already exists"
            );
        }
        Product[]tmp = new Product[items.length + 1];
            for (int i = 0; i < items.length; i++) {
                tmp[i] = items[i];
            }
            tmp[tmp.length - 1] = productForAdd;
            items = tmp;
        }

    public void addNewProductsWhenMoreThanOneSimilarItemIsPresent(Product productForAdd) {
//        Product draft_1 = findById(productForAdd.getId());
//        if (draft_1 != null) {
//            throw new AlreadyExistsException(
//                    "Element with id: " + productForAdd.getId() + " already exists"
//            );
//        }
        Product[]tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = productForAdd;
        items = tmp;
    }

        public void removeProductById (int id){
            Product draft_2 = findById(id);
            if (draft_2 == null) {
                throw new NotFoundException(
                        "Element with id: " + id + " not found"
                );
            }
            Product[] tmp = new Product[items.length - 1];
            int copyToIndex = 0;
            for (Product item : items) {
                if (item.getId() != id) {
                    tmp[copyToIndex] = item;
                    copyToIndex++;
                }
            }
            items = tmp;
        }

        public Product findById(int id){
            for (Product item : items) {
                if (item.getId() == id) {
                    return item;
                }
            }
            return null;
        }

        public Product[] getSavedProducts () {
            return items;
        }

    }
