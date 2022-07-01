package ru.netology.product;

public class Smartphone extends Product {
    protected static String manufacturer;

    public Smartphone (int id, String name, int price, String manufacturer) {
        super(id, name, price);
        Smartphone.manufacturer = manufacturer;
    }

    public static String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Smartphone.manufacturer = manufacturer;
    }

    @Override
    public boolean matches(Product product, String search) {
        if (super.matches(product, search)) {
            return true;
        }
        return getManufacturer().contains(search);
    }
}
