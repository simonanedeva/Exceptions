package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.Exceptions;
import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.contracts.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {

    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 10;
    private static final String NAME_INVALID_MESSAGE = "Name should be between 3 and 10 symbols.";

    private String name;
    private final List<Product> products;

    public CategoryImpl(String name) {
        setName(name);
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        Exceptions.validateStringLength(name, NAME_MIN_LENGTH, NAME_MAX_LENGTH, NAME_INVALID_MESSAGE);
        this.name = name;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public String print() {
        if (products.size() == 0) {
            return String.format(
                    "#Category: %s%n" +
                    " #No product in this category",
                    name);
        }

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(String.format("#Category: %s%n", name));

        for (Product product : products) {
            strBuilder.append(product.print());
            strBuilder.append(String.format(" ===%n"));
        }

        return strBuilder.toString();
    }

}
