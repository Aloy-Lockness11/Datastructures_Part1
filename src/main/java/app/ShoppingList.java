package app;

import utils.DynamicArrayList;

import java.util.Scanner;

/**
 *
 * @author michelle
 */
//Aloysius Wilfred Pacheco D00253302

public class ShoppingList {
    public static void main(String[] args) {

        //Creates an instance of your DynamicArrayList class
        Scanner sc = new Scanner(System.in);
        DynamicArrayList shoppnList = new DynamicArrayList();

        //Asks the user how many entries they’d like to add to their shopping list.
        System.out.println("Enter how many inputs you need to add captain : ");
        int totalInp = sc.nextInt();
        sc.nextLine();

        //Prompts the user to enter the specified number of entries for their shopping list and adds each to the list (each
        //line can contain one or more words each, or may be null)
        for (int i = 0; i < totalInp; i++) {
            System.out.print("Enter entry (UwU)/ number:" + (i + 1) + ": ");
            String entry = sc.nextLine();
            shoppnList.add(entry);
        }

        //Loops through the shopping list and displays the content.
        int opt = -1;
        do{

            //Repeatedly offers a menu of actions that can be done by the shopping list (based on the functionality you have
            //been tasked with) and provides the logic for each.
            displayMenu();
            System.out.print("Choose an option from the list captain!!: ");
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {

                case 1:
                    //ADD
                    System.out.print("Enter item to add: ");
                    String newEntry = sc.nextLine();
                    shoppnList.add(newEntry);
                    break;

                case 2:
                    //REMOVE
                    System.out.print("Enter item to remove: ");
                    String entryToRemove = sc.nextLine();

                    System.out.print("Enter position to start removal: ");
                    int fromPos = sc.nextInt();
                    sc.nextLine();

                    boolean removed = shoppnList.remove(entryToRemove, fromPos);
                    if (removed) {
                        System.out.println("item removed successfully.");
                    } else {
                        System.out.println("item does not exist ");
                    }
                    break;

                case 3:
                    //DISPLAY
                    System.out.println("Your shopping list:");
                    displayShopnList(shoppnList);
                    break;

                case 4:
                    //CLEAR
                    shoppnList.clear();
                    System.out.println("Shopping list cleared. phew");
                    displayShopnList(shoppnList);
                    break;

                case 0:
                    //EXIT
                    System.out.println("Exiting the shopping list application. Sayonara captain!");
                    break;

                default:
                    //WARNING
                    System.out.println("What are you doing captain Try again ᐠ=ᗜ△ᗜ=ᐟ  ");
            }
        }while (opt!=0);
    }

    /**
     *
     * Displays Shopping list
     *
     * @param shopnList takes shoping list instance
     */
    public static void displayShopnList(DynamicArrayList shopnList){
        System.out.println();
        System.out.print("[");
        for (int i = 0; i < shopnList.size(); i++) {
            System.out.print(" {"+(i) + "} " + shopnList.get(i)+" , ");
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * Displays menu
     */
    public static void displayMenu(){
        System.out.println("\nMenu:");
        System.out.println("1| Add");
        System.out.println("2| Remove");
        System.out.println("3| Display");
        System.out.println("4| Clear");
        System.out.println("0| Exit");
    }
}
