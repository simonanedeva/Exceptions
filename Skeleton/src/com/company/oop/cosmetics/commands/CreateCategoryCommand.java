package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.Exceptions;
import com.company.oop.cosmetics.OurOwnException;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;

import java.util.List;

public class CreateCategoryCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_PARAMETERS = 1;
    private static final String CATEGORY_CREATED = "Category with name %s was created!";

    private final ProductRepository productRepository;

    public CreateCategoryCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        Exceptions.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_PARAMETERS);
        String categoryName = parameters.get(0);
        return createCategory(categoryName);
    }

    private String createCategory(String categoryName) {

        if (productRepository.categoryExist(categoryName)){
            throw new OurOwnException("Category already exists.");
        }

        productRepository.createCategory(categoryName);

        return String.format(CATEGORY_CREATED, categoryName);
    }

}
