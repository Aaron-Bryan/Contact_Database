import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contacts> contacts;
    private static Scanner user_input;

    //Methods
    //Menu Methods
    private static void option_select() {
        System.out.println("What would you like to do?");

        System.out.println("1.Manage Contacts");
        System.out.println("2.Messages");
        System.out.println("3.Quit");

        int choice = user_input.nextInt();

        switch (choice){
            case(1):
                manage_contacts();
                break;
            case(2):
                manage_messages();
                break;
            case(3):
                //Quit
                break;
            default:
                System.out.println("Choose one of the choices mf");
                break;
        }

    }

    private static void manage_contacts() {
        System.out.println("What would you like to do?");

        System.out.println("1.Show all contacts");
        System.out.println("2.Add new contact");
        System.out.println("3.Search for a contact");
        System.out.println("4.Delete a contact");
        System.out.println("5.Return to menu");

        user_input = new Scanner(System.in);
        int choice = user_input.nextInt();

        switch (choice){
            case(1):
                show_contacts();
                break;
            case(2):
                add_new_contact();
                break;
            case(3):
                contact_search();
                break;
            case(4):
                delete_contact();
                break;
            case(5):
                option_select();
                break;
        }

    }

    private static void manage_messages() {
        System.out.println("What would you like to do?");

        //TODO Options to select on the Messages section

        user_input = new Scanner(System.in);
        int choice = user_input.nextInt();
    }

    //Function Methods - Manage contacts
    private static void add_new_contact(){

    }

    private static void contact_search(){

    }

    private static void show_contacts(){

    }

    private static void delete_contact(){

    }

    public static void main(String[] args) {

        contacts = new ArrayList<>();

        //Greet the user
        System.out.println("Greetings mf");

        option_select();

    }

}