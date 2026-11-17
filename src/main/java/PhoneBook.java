// Import Scanner class to read user input from the console
import java.util.Scanner;

public class PhoneBook {
    // Create instances of the Sqlite helper class and Scanner for user input
    Sqlite sql = new Sqlite();
    Scanner input = new Scanner(System.in);

    // Displays the main menu and handles user navigation in an infinite loop
    public void menu() {

        // Initialize database connection and ensure the table exists before starting
        sql.connect();
        sql.createNawTable();

        // Infinite loop to keep the program running until the user chooses to exit (0)
        while (true) {
            System.out.println("Type the number of the operation you want\n");
            // Text block (""" ... """) to display the formatted menu options
            System.out.println("""
                    ---------------**** PHONE DICTIONURAY ****-----------------                         
                    
                    --- MENU ---
                    
                    0-EXIT THE SYSTEM
                    _________________
                    1-ADD NEW CONTACT
                    _________________
                    2-SHOW ALL CONTACT
                    _________________
                    3-REMOVE A CONTACT
                    _________________
                    4-MODIFY A CONTACT                       
                    
                    """
            );

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine(); // Consume the leftover newline character (\n) from nextInt()

            // Modern switch expression (rule switch) using '->' to route user choices
            switch (choice) {

                case 0 -> {
                    System.out.println("\nExiting Phone Dictionary... Goodbye!");
                    System.exit(0); // Immediately terminates the Java program
                }
                case 1 -> {
                    add();
                    break;
                }
                case 2 -> {
                    views();
                    break;
                }
                case 3 -> {
                    remove();
                    break;
                }
                case 4 -> {
                    modify();
                    break;
                }

                // Runs if the user enters any number other than 0-4
                default -> System.out.println("\nInvalid choice! Please enter a number between 0 and 4.");
            }

            System.out.println();
        }
    }

    // Collects contact details from the user and saves them to the database
    public void add() {
        System.out.println("what is the name of the person?");
        String name = input.nextLine(); // Reads full line (allows spaces in the name)

        System.out.println("what is the PhoneNumber of the person?");
        int number = input.nextInt();

        System.out.println("what is your relationship with the person?");
        String relation = input.next(); // Reads a single word

        // String.valueOf(number) converts the int phone number into a String to match insert() parameters
        sql.insert(name, String.valueOf(number), relation);
        System.out.println("DONE");
    }

    // Calls the database method to print all stored contacts
    public void views() {
        sql.printDate();
    }

    // Prompts for a contact ID and deletes that record from the database
    public void remove() {
        System.out.println("type the ID you want to remove");
        int id = input.nextInt();
        input.nextLine(); // Clears the input buffer
        sql.delete(id);
    }

    // Prompts for a contact ID and allows updating one of its attributes (name, phone, or relation)
    public void modify() {
        System.out.println("type the ID of the person that you want to modify,\ntype 0 to go back to the menu");
        int ID = input.nextInt();
        input.nextLine();

        // Early return: exits the modify() method and returns to menu() if user enters 0
        if (ID == 0) {
            return;
        }

        System.out.println("Enter the number of attribute that you want to modify");
        System.out.println("""
                1-name
                2-phonenumber
                3-relation
                """);
        int num = 0;
        num = input.nextInt();

        // Calls the appropriate overloaded sql.update() method based on the chosen attribute
        switch (num) {
            case 1 -> {
                System.out.println("what is the new value?");
                String newName = input.next();
                sql.update(ID, newName); // Calls update(int, String)
                break;
            }

            case 2 -> {
                System.out.println("what is the new value?");
                int newNum = input.nextInt();
                sql.update(ID, newNum);  // Calls update(int, int)
                break;
            }

            case 3 -> {
                System.out.println("what is the new value?");
                String newRealation = input.next();
                sql.update(newRealation, ID); // Calls update(String, int)
                break;
            }

            default -> {
                System.out.println("invalid input!");
            }
        }
    }
}