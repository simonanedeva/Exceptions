package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.Exceptions;
import com.company.oop.cosmetics.OurOwnException;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.models.GenderType;

import java.util.List;

public class CreateProductCommand implements Command {

    private static final String PRODUCT_CREATED = "Product with name %s was created!";
    private static final int EXPECTED_NUMBER_OF_PARAMETERS_COMMAND = 4;
    private static final String INVALID_GENDER_TYPE_VALUE = "Invalid gender type.";

    private final ProductRepository productRepository;

    public CreateProductCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        Exceptions.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_PARAMETERS_COMMAND);
        String name = parameters.get(0);
        String brand = parameters.get(1);

        double price = Double.parseDouble(parameters.get(2));
        Exceptions.validatePrice(price, "Price");

        GenderType gender;
        try {
            gender = GenderType.valueOf(parameters.get(3).toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new OurOwnException(INVALID_GENDER_TYPE_VALUE);
        }

        gender = GenderType.valueOf(parameters.get(3).toUpperCase());
        return createProduct(name, brand, price, gender);
    }

    private String createProduct(String name, String brand, double price, GenderType gender) {

        if (productRepository.productExist(name)){
            throw new OurOwnException("Product already exists.");
        }

        productRepository.createProduct(name, brand, price, gender);

        return String.format(PRODUCT_CREATED, name);
    }

}
