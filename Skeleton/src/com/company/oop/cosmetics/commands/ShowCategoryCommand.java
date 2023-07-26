package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.Exceptions;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.models.contracts.Category;

import java.util.List;

public class ShowCategoryCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_PARAMETERS = 1;
    private final ProductRepository productRepository;

    public ShowCategoryCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        Exceptions.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_PARAMETERS);

        String categoryName = parameters.get(0);

        return showCategory(categoryName);
    }

    private String showCategory(String categoryName) {
        Category category = productRepository.findCategoryByName(categoryName);

        return category.print();
    }

}
