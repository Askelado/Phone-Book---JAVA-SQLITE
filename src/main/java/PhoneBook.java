import java.util.ArrayList;
import java.util.Scanner;
public class PhoneBook {

    Scanner input = new Scanner(System.in);
    ArrayList<Contact> contacts =new ArrayList<>();

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

                }

                default -> System.out.println("\nInvalid choice! Please enter a number between 0 and 4.");
            }

            System.out.println();
        }
    }

    public void add(){
        System.out.println("what is the name of the person?");
        String name = input.nextLine();
        System.out.println("what is the number of the person?");
        int number = input.nextInt();
        System.out.println("what is your relationship with the person?");
        String relation =input.nextLine();

        contacts.add(new Contact(name,number,relation));
        System.out.println("DONE");
    }

    public void views(){
        while (true) {
            for (Contact c : contacts) {
                c.toString();
            }
            System.out.println("type 1 to go back");
            int num =input.nextInt();
            if (num==1){
                return;
            }
        }
    }

    public void remove(){
        System.out.println("type the name of the contact you want to remove");
        String name = input.nextLine();

        for (Contact c : contacts){
            if (c.getname().equals(name)){
                contacts.remove(this);
                System.out.println("DONE");
                return;
            }
        }
    }

    public void modify(){
        System.out.println("Enter the number of attribute that you want to modify");
        System.out.println("""
                1-name
                2-phonenumber
                3-relation 
                """);
        int num = 0;
        boolean bool =true;
        while(bool)
        num =input.nextInt();
        switch (num){
            case 1 -> {
                System.out.println("what name you want to modify?");
                String oldName = input.nextLine();
                System.out.println("what is the new value?");
                String newname =input.nextLine();
                for (Contact c : contacts){
                    if (c.getname().equals(oldName)){
                     c.setname(newname);
                     System.out.println("Done");
                     bool=false;
                    }
                }
            }

            case 2 -> {
                System.out.println("what phonenum you want to modify?");
                int oldNum = input.nextInt();
                System.out.println("what is the new value?");
                int newNum =input.nextInt();
                for (Contact c : contacts){
                    if (c.getPhonenum() == oldNum){
                        c.setPhonenum(newNum);
                        System.out.println("Done");
                        bool=false;
            }
        }

    }
}
