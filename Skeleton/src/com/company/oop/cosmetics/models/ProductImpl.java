package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;

import static com.company.oop.cosmetics.Exceptions.validatePrice;
import static com.company.oop.cosmetics.Exceptions.validateStringLength;

public class ProductImpl implements Product {

    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 10;
    private static final String NAME_INVALID_MESSAGE = "Name should be between 3 and 10 symbols.";

    public static final int BRAND_MIN_LENGTH = 2;
    public static final int BRAND_MAX_LENGTH = 10;
    private static final String BRAND_INVALID_MESSAGE = "Brand should be between 2 and 10 symbols.";


    private String name;
    private String brand;
    private double price;
    private final GenderType gender;

    public ProductImpl(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        validateStringLength(name, NAME_MIN_LENGTH, NAME_MAX_LENGTH, NAME_INVALID_MESSAGE);
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        validateStringLength(name, BRAND_MIN_LENGTH, BRAND_MAX_LENGTH, BRAND_INVALID_MESSAGE);
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        validatePrice(price, "Price");
        this.price = price;
    }

    public GenderType getGender() {
        return gender;
    }

    @Override
    public String print() {
        return String.format(
                "#%s %s%n" +
                " #Price: $%.2f%n" +
                " #Gender: %s%n",
                name,
                brand,
                price,
                gender);
    }

}
