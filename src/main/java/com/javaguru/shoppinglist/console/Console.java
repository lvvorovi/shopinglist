package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.validation.exceptions.ValidationException;
import com.javaguru.shoppinglist.service.validation.exceptions.WrongMenuInputException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Console {

    private final List<MenuAction> actions;

    public Console(List<MenuAction> actions) {
        this.actions = actions;
    }

    public void execute() {

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);

                for (int i = 0; i < actions.size(); i++) {
                    System.out.println((i + 1) + ". " + actions.get(i));
                }
                int userInput = Integer.parseInt(scanner.nextLine());
                if (userInput < 1 || userInput > 6) {
                    throw new WrongMenuInputException("Wrong menu input. " +
                            "Please chose option from 1 to " + actions.size() +
                            " and try again." + '\n');
                }
                actions.get(userInput - 1).execute();

            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
