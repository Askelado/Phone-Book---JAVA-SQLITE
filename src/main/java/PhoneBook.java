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
}
