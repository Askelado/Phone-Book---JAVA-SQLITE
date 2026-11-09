import java.util.ArrayList;
import java.util.Scanner;
public class PhoneBook {

    Scanner input = new Scanner(System.in);
    ArrayList<Contact> contacts =new ArrayList<>();
    private int number;

    public void menu() {
        System.out.println("Type the number of the operation you want\n");
        System.out.println("""
---------------**** PHONE DICTIONURAY ****-----------------                         

--- MENU ---

1-ADD NEW CONTACT
_________________
2-SHOW ALL CONTACT
_________________
3-REMOVE A CONTACT
_________________
4-MODIFY A CONTACT                       

        """
        );
        number = input.nextInt();
    }

    public void add(){
        System.out.println("what is the name of the person?");
        String name = input.nextLine();
        System.out.println("what is the number of the person?");
        int number = input.nextInt();
        System.out.println("what is your relationship with the person?");
        String relation =input.nextLine();

        contacts.add(new Contact(name,number,relation));
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
}
