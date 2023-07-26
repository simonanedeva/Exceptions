package com.company.oop.cosmetics.core;

import com.company.oop.cosmetics.OurOwnException;
import com.company.oop.cosmetics.commands.*;
import com.company.oop.cosmetics.core.contracts.CommandFactory;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;

public class CommandFactoryImpl implements CommandFactory {

    private static final String INVALID_COMMAND = "Invalid command name: %s!";

    @Override
    public Command createCommandFromCommandName(String commandTypeValue, ProductRepository productRepository) {
        CommandType commandType = CommandType.valueOf(commandTypeValue.toUpperCase());

            switch (commandType) {
                case CREATECATEGORY:
                    return new CreateCategoryCommand(productRepository);
                case CREATEPRODUCT:
                    return new CreateProductCommand(productRepository);
                case ADDPRODUCTTOCATEGORY:
                    return new AddProductToCategoryCommand(productRepository);
                case SHOWCATEGORY:
                    return new ShowCategoryCommand(productRepository);
                default:
                    throw new OurOwnException(String.format(INVALID_COMMAND, commandType));
            }
    }
}
