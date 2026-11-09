import java.util.Scanner;
public class PhoneBook {

    private int number;

    Scanner input = new Scanner(System.in);

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
    
}
