import java.util.ArrayList;
import java.util.Scanner;
public class PhoneBook {

    Scanner input = new Scanner(System.in);
    ArrayList<Contact> contacts = new ArrayList<>();

    public void menu() {

        while (true) {
            System.out.println("Type the number of the operation you want\n");
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
            input.nextLine();

            switch (choice) {

                case 0 -> {
                    System.out.println("\nExiting Phone Dictionary... Goodbye!");
                    System.exit(0);
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

                default -> System.out.println("\nInvalid choice! Please enter a number between 0 and 4.");
            }

            System.out.println();
        }
    }

    public void add() {
        System.out.println("what is the name of the person?");
        String name = input.nextLine();
        System.out.println("what is the number of the person?");
        int number = input.nextInt();
        System.out.println("what is your relationship with the person?");
        String relation = input.next();

        contacts.add(new Contact(name, number, relation));
        System.out.println("DONE");
    }

    public void views() {
        for (Contact c : contacts) {
            System.out.println(c.toString());
        }
    }

    public void remove() {
        System.out.println("type the ID you want to remove");
        int id = input.nextInt();
        input.nextLine();

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getID() == id) {
                contacts.remove(i);

                for (int j = i; j < contacts.size(); j++) {
                    contacts.get(j).setID(contacts.get(j).getID() - 1);
                }
                Contact.IDcounter = contacts.size() + 1;
                System.out.println("DONE");
                System.out.println("You entered ID: " + id);

                for (Contact c : contacts) {
                    System.out.println("Stored ID: " + c.getID()
                            + " | Name: " + c.getname());
                }
                break;
            }
        }
    }

    public void modify() {
        boolean bool = true;
        boolean found = false;
        while (bool){
          System.out.println("type the ID of the person that you want to modify,\n type 0 to go back to the menu");
          int ID = input.nextInt();
          input.nextLine();
          if (ID == 0){
              break;
          }
          for (Contact c : contacts) {
                    if (c.getID() == ID) {
                        found=true;
                        System.out.println("Enter the number of attribute that you want to modify");
                        System.out.println("""
                                1-name
                                2-phonenumber
                                3-relation
                                4-back to the menu
                                """);
                        int num = 0;
                        num = input.nextInt();
                        switch (num) {
                            case 1 -> {
                                System.out.println("what is the new value?");
                                String newName = input.next();
                                c.setname(newName);
                                System.out.println("Done");
                                bool = false;
                                break;
                            }

                            case 2 -> {
                                System.out.println("what is the new value?");
                                int newNum = input.nextInt();
                                c.setPhonenum(newNum);
                                System.out.println("Done");
                                bool = false;
                                break;
                            }

                            case 3 -> {
                                System.out.println("what is the new value?");
                                String newRealation = input.next();
                                c.setRelation(newRealation);
                                System.out.println("Done");
                                bool = false;
                                break;
                            }

                            case 4-> {
                                return;
                            }
                        }
                        break;
                    }
                }
                   if (!found) {
                       System.out.println("invalid input!");
                   }
            }
        }
    }
