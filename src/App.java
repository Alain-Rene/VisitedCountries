/*
 * Program that will let the user search for countries and list out who has 
 * visited those countries
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Variable declaration
        Scanner sc = new Scanner(System.in);
        ArrayList<String> peopleNames = new ArrayList<>();
        peopleNames.add("Martina");
        peopleNames.add("DeAngelo");
        peopleNames.add("David B");
        peopleNames.add("Alain");

        ArrayList<HashSet<String>> countries = new ArrayList<>();
        countries.add(new HashSet<>()); // index 0, Martina
        countries.get(0).add("Japan");
        countries.get(0).add("Mexico");
        countries.get(0).add("Phillippines");
        countries.get(0).add("Singapore");
        countries.get(0).add("United States");

        countries.add(new HashSet<>()); // index 1, DeAngelo
        countries.get(1).add("United States");
        countries.get(1).add("Canada");
        countries.get(1).add("Phillippines");

        countries.add(new HashSet<>());// index 2, David B
        countries.get(2).add("United States");
        countries.get(2).add("Mexico");
        countries.get(2).add("Italy");

        countries.add(new HashSet<>());// index 3, Alain
        countries.get(3).add("United States");
        countries.get(3).add("Mexico");
        countries.get(3).add("Canada");

        boolean runProgram = true;
        String userInput;

        System.out.println("Welcome to the visited countries terminal!");
        do {
            // Display menu
            System.out.println("Here are your options:");
            System.out.println("A. See all the people that have visited a country");
            System.out.println("B. Add a country to a person's set of visited countries");
            System.out.println("C. See all the countries a person has visited");
            System.out.println("Q. Quit");
            userInput = sc.nextLine();

            // Menu choices
            if (userInput.toLowerCase().equals("a")) {
                boolean targetFound = false;
                while (targetFound == false) {
                    HashSet<String> uniqueCountries = new HashSet<>();
                    System.out.println("Which Country would you like to search for? Here are your options:");

                    // Adds all the countries into a new HashSet to remove duplicates
                    for (HashSet<String> c : countries) {
                        uniqueCountries.addAll(c);
                    }
                    // Display all the countries
                    for (String country : uniqueCountries) {
                        System.out.println(country);
                    }
                    String targetString = sc.nextLine();

                    // Checks if the user's input can be found in the countries array list
                    for (int i = 0; i < countries.size(); i++) {
                        HashSet<String> currentCountries = countries.get(i);
                        if (currentCountries.contains(targetString)) {
                            targetFound = true;
                            System.out.println(peopleNames.get(i));
                        }
                    }

                    // If no matching country is found, display error message
                    if (targetFound == false) {
                        System.out.println("No matching country found, please try again");
                    }
                }
            } else if (userInput.toLowerCase().equals("b")) {
                int index = 0;
                do {
                    System.out.println("Who would you like to add a country to?");

                    // Displays list of all names
                    for (String n : peopleNames) {
                        System.out.println(n);
                    }
                    String targetString = sc.nextLine();

                    // indexOf returns -1 if value is not found in the array list
                    index = peopleNames.indexOf(targetString);
                    if (index == -1) {
                        System.out.println("This person cannot be found! Please try again.");
                    } else {
                        // Allows user to add country of their choice
                        System.out.println("Please enter the country you are adding:");
                        userInput = sc.nextLine();
                        countries.get(index).add(userInput);
                        System.out.println(userInput + " has been added for " + targetString);
                    }
                } while (index == -1);
            } else if (userInput.toLowerCase().equals("c")) {
                int index = 0;
                do {

                    System.out.println("Which person's country list would you like to see? Here are your options:");

                    for (String n : peopleNames) {
                        System.out.println(n);
                    }
                    userInput = sc.nextLine();

                    index = peopleNames.indexOf(userInput);
                    if (index == -1) {
                        System.out.println("This person cannot be found! Please try again");
                    } else {
                        HashSet<String> pCountries = countries.get(index);
                        System.out.println(userInput + " has been to these countries!");
                        for (String c : pCountries) {
                            System.out.println(c);
                        }
                    }

                } while (index == -1);
            } else if (userInput.toLowerCase().equals("q")) {
                // Close scanner and then finish program
                sc.close();
                System.out.println("Thank you for using the visited countries terminal");
                runProgram = false;
            } else {
                System.out.println("Invalid input, please try again");
            }

        } while (runProgram);
    }
}
