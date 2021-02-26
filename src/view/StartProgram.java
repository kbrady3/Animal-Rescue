/*
 * Kabrina Brady
 * CIS 171 - Spring 2021
 * 2/9/2021
 */

package view;

import controller.AnimalRescueHelper;
import model.AnimalRescue;

import java.util.List;
import java.util.Scanner;

public class StartProgram {

    static Scanner in = new Scanner(System.in);
    static AnimalRescueHelper lih = new AnimalRescueHelper();

    private static void addAnItem() {
        System.out.print("Enter a name for your animal: ");
        String animalName = in.nextLine();
        System.out.print("Enter an animal type: ");
        String animalType = in.nextLine();
        System.out.println("Enter the vendor ID: ");
        int vendorId = in.nextInt();

        AnimalRescue toAdd = new AnimalRescue(animalName, animalType, vendorId);
        lih.insertItem(toAdd);
    }

    private static void deleteAnItem() {
        System.out.print("Enter the animal's name to delete: ");
        String animalName = in.nextLine();
        System.out.print("Enter the animal type to delete: ");
        String animalType = in.nextLine();
        System.out.println("Enter the vendor ID to delete: ");
        int vendorId = in.nextInt();

        AnimalRescue toDelete = new AnimalRescue(animalName, animalType, vendorId);
        lih.deleteItem(toDelete);
    }

    private static void editAnItem() {
        System.out.println("1: Search by Animal's Name");
        System.out.println("2: Search by Animal Type");
        int searchBy = in.nextInt();
        in.nextLine();
        List<AnimalRescue> foundItems;
        if (searchBy == 1) {
            System.out.print("Enter the animal's name: ");
            String animalName = in.nextLine();
            foundItems = lih.searchForItemByAnimalName(animalName);
        } else {
            System.out.print("Enter the animal type: ");
            String animalType = in.nextLine();
            foundItems = lih.searchForItemByAnimalType(animalType);
        }

        if (!foundItems.isEmpty()) {
            for (AnimalRescue l : foundItems) {
                System.out.println(l.getId() + " : " + l.returnAnimalDetails());
            }
            System.out.print("Select the ID of the animal to edit: ");
            int idToEdit = in.nextInt();

            AnimalRescue toEdit = lih.searchForItemById(idToEdit);
            System.out.println("Retrieved " + toEdit.getAnimalType() + " from " + toEdit.getanimalName());
            System.out.println("1: Update Animal Name");
            System.out.println("2: Update Animal Type");
            int update = in.nextInt();
            in.nextLine();

            if (update == 1) {
                System.out.print("New Animal Name: ");
                String newAnimalName = in.nextLine();
                toEdit.setanimalName(newAnimalName);
            } else if (update == 2) {
                System.out.print("New Animal Type: ");
                String newAnimalType = in.nextLine();
                toEdit.setAnimalType(newAnimalType);
            }

            lih.updateItem(toEdit);

        } else {
            System.out.println("No results found");
        }
    }

    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu() {
        boolean goAgain = true;
        System.out.println("Adopt your new furry best friend!");
        while (goAgain) {
            System.out.println("Select an action:");
            System.out.println("1: Add a type");
            System.out.println("2: Edit a type");
            System.out.println("3: Delete an item");
            System.out.println("4: View the list");
            System.out.println("5: Exit the program");
            System.out.print("Your selection: ");
            int selection = in.nextInt();
            in.nextLine();

            if (selection == 1) {
                addAnItem();
            } else if (selection == 2) {
                editAnItem();
            } else if (selection == 3) {
                deleteAnItem();
            } else if (selection == 4) {
                viewTheList();
            } else {
                lih.cleanUp();
                System.out.println("Exiting program");
                goAgain = false;
            }
        }
    }

    private static void viewTheList() {
        List<AnimalRescue> allItems = lih.showAllItems();
        for(AnimalRescue singleItem : allItems){
            System.out.println(singleItem.returnAnimalDetails());
        }
    }
}