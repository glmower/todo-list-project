package App;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static ArrayList<List> lists = new ArrayList<>();
    public static int listCount = 0;

    public static void main(String[] args) throws Exception {
        boolean running = true;
        Scanner scnr = new Scanner(System.in);
        while (running) {
            printMainMenu();
            try {
                int choice = scnr.nextInt();
                printDivider();
                switch (choice) {
                    case 1:
                        createNewList();
                        break;
                    case 2:
                        viewAllLists();
                        break;
                    case 3:
                        viewList();
                        break;
                    case 4:
                        addItemToList();
                        break;
                    case 5:
                        removeItemFromList();
                        break;
                    case 6:
                        markItemAsDone();
                        break;
                    case 7:
                        markItemAsNotDone();
                        break;
                    case 8:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice");

                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                scnr.nextLine();
            }
        }
        scnr.close();
    }

    public static void printDivider() {
        System.out.println("--------------------------------------------------");
    }

    public static void printMainMenu() {
        printDivider();
        System.out.println("Main Menu");
        System.out.println("1. Create a new list");
        System.out.println("2. View all lists");
        System.out.println("3. View a list");
        System.out.println("4. Add an item to a list");
        System.out.println("5. Remove an item from a list");
        System.out.println("6. Mark an item as done");
        System.out.println("7. Mark an item as not done");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void createNewList() {
        System.out.print("Enter the name of the new list: ");
        String name = System.console().readLine();
        List list = new List(name);
        lists.add(list);
        System.out.println("List created successfully");
    }

    public static void viewAllLists() {
        printDivider();
        System.out.println("All Lists");
        for (List list : lists) {
            System.out.println(list.getName());
        }
        printDivider();
    }

    public static void viewList() {
        printDivider();
        System.out.print("Enter the name of the list to view: ");
        String name = System.console().readLine();
        List list = findList(name);
        if (list != null) {
            list.print();
        }
        printDivider();
    }

    public static void addItemToList() {
        printDivider();
        System.out.print("Enter the name of the list to add the item to: ");
        String name = System.console().readLine();
        List list = findList(name);
        if (list != null) {
            System.out.print("Enter the item to add: ");
            String item = System.console().readLine();
            list.add(item);
            System.out.println("Item added successfully");
        } else {
            System.out.println("List not found");
        }
        printDivider();
    }

    public static void removeItemFromList() {
        printDivider();
        System.out.print("Enter the name of the list to remove the item from: ");
        String name = System.console().readLine();
        List list = findList(name);
        if (list != null) {
            System.out.print("Enter the index of the item to remove: ");
            int index = Integer.parseInt(System.console().readLine());
            list.remove(index);
            System.out.println("Item removed successfully");
        } else {
            System.out.println("List not found");
        }
        printDivider();
    }

    public static void markItemAsDone() {
        printDivider();
        System.out.print("Enter the name of the list to mark the item as done: ");
        String name = System.console().readLine();
        List list = findList(name);
        if (list != null) {
            System.out.print("Enter the index of the item to mark as done: ");
            int index = Integer.parseInt(System.console().readLine());
            list.markAsDone(index);
            System.out.println("Item marked as done successfully");
        } else {
            System.out.println("List not found");
        }
        printDivider();
    }

    public static void markItemAsNotDone() {
        printDivider();
        System.out.print("Enter the name of the list to mark the item as not done: ");
        String name = System.console().readLine();
        List list = findList(name);
        if (list != null) {
            System.out.print("Enter the index of the item to mark as not done: ");
            int index = Integer.parseInt(System.console().readLine());
            list.markAsNotDone(index);
            System.out.println("Item marked as not done successfully");
        } else {
            System.out.println("List not found");
        }
        printDivider();
    }

    public static List findList(String name) {
        for (List list : lists) {
            if (list.getName().equals(name)) {
                return list;
            }
        }
        return null;
    }
}
