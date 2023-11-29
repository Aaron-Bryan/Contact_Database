import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contacts> contacts_arraylist;
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
    private static void show_contacts(){
        System.out.println("Showing all contacts..");
        for(Contacts ctr: contacts_arraylist){
            ctr.get_contact_details();
        }

        option_select();
    }

    private static void add_new_contact(){
        System.out.println("Adding new Contact");

        System.out.println("Please enter contact's name: ");
        String new_name = user_input.next();
        System.out.println("Please enter contact's number: ");
        String new_number = user_input.next();
        System.out.println("Please enter contact's email: ");
        String new_email = user_input.next();

        if (new_name.equals("") || new_number.equals("") || new_email.equals("")){
            System.out.println("Invalid, Please fill all fields");
            add_new_contact();
        }
        else {
            Contacts new_contact = new Contacts(new_name, new_number, new_email);
            contacts_arraylist.add(new_contact);
        }

        option_select();
    }

    private static void contact_search(){
        System.out.println("Please enter the contact name you want to search: ");
        String search_name = user_input.next();
        if (search_name.equals("")){
            System.out.println("Invalid, Please fill all fields");
            add_new_contact();
        }
        else {
            for (Contacts ctr: contacts_arraylist){
                if (ctr.getContact_name().equals(search_name)){
                    ctr.get_contact_details();
                }
            }
        }

    }

    private static void delete_contact(){
        System.out.println("Please enter the contact name you want to delete: ");
    }

    public static void main(String[] args) {

        contacts_arraylist = new ArrayList<>();

        //Greet the user
        System.out.println("Greetings mf");

        option_select();

    }

}