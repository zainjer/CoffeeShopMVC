package com.company.controllers;

import com.company.util.Log;

import java.io.IOException;
import java.util.Scanner;


public class MainMenuController {

    public static void initiateMainMenu(){

        while (true) {
            System.out.println("*********** Welcome to Digital Coffee Shop! ***********\n");
            System.out.println("* 1. View Our Menu");
            System.out.println("* 2. View Current Orders");
            System.out.println("* 3. View Current Customers");
            System.out.println("* 4. Make an Order");
            System.out.println("* 0. Exit");
            System.out.println("*******************************************************\n");
            System.out.println("Write a number to continue!\n$ ");

            Log.add("Printed Main Menu");

            Scanner in = new Scanner(System.in);

            var result = in.nextLine();

            try{
                performOperations(result.trim());
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    private static void performOperations(String input) throws IOException {

        int optionNumber = -1;
        try{
            optionNumber = Integer.parseInt(input);
        }catch (NumberFormatException e)
        {
            System.out.println("Wrong input format!\t Please Try Again...\n\n");
            return;
        }

        Scanner in = new Scanner(System.in);
        switch (optionNumber) {

            case 0 -> {
                Log.add("Chose 0 in MainMenu");
                System.out.println("\n********** Thank you for using Digital Coffee Shop! **********\n");
                //Todo -- Add Summary part here!
                System.exit(0);
            }
            case 1 -> {
                Log.add("Chose 1 in MainMenu");
                MenuItemController.printMenu();
                continueMessage();
                in.nextLine();
            }
            case 2 -> {
                Log.add("Chose 2 in MainMenu");
                OrdersController.printOrders();
                continueMessage();
                in.nextLine();
            }
            case 3 -> {
                Log.add("Chose 3 in MainMenu");
                CustomerController.printcustomer();
                continueMessage();
                in.nextLine();
            }
            case 4 -> {
                Log.add("Chose 4 in MainMenu");
                System.out.println("-- Order features is currently under development");
                continueMessage();
                in.nextLine();
            }
            default -> {
                System.out.println(" -- Invalid Option Selected!\t Please try again...");
                continueMessage();
                in.nextLine();
            }
        }

    }

    static void continueMessage(){
        System.out.println("Press Enter to Continue..");
    }

}
