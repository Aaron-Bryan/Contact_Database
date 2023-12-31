import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contacts> contacts_arraylist;
    private static ArrayList<Messages> messages_arraylist;
    private static Scanner user_input;
    private static int contact_id = 0;

    boolean contact_exists = true;

    //Methods
    //Menu Methods
    private static void option_select() {
        System.out.println("What would you like to do?");

        System.out.println("1.Manage Contacts");
        System.out.println("2.Messages");
        System.out.println("3.Quit");

        user_input = new Scanner(System.in);
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
                System.out.println("Choose o    ne of the choices mf");
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

        int choice = user_input.nextInt();

        switch (choice){
            case (1):
                show_contacts();
                break;
            case (2):
                add_new_contact();
                break;
            case (3):
                contact_search();
                break;
            case (4):
                delete_contact();
                break;
            case (5):
                option_select();
                break;
            default:
                System.out.println("Choose mf");
                manage_contacts();
                break;
        }

    }

    private static void manage_messages() {
        System.out.println("What would you like to do?");

        System.out.println("What would you like to do?");

        System.out.println("1.Show all messages");
        System.out.println("2.Send a new message");
        System.out.println("3.Return to menu");

        int choice = user_input.nextInt();

        switch (choice){
            case (1):
                show_messages();
                break;
            case (2):
                send_message();
                break;
            case (3):
                option_select();
                break;
            default:
                System.out.println("Choose mf");
                manage_messages();
                break;
        }
    }


    //Function Methods - Manage contacts
    private static void show_contacts(){
        System.out.println("Showing all contacts..");
        for(Contacts ctr: contacts_arraylist){
            ctr.get_contact_details();
            System.out.println("*******************");
        }

        option_select();
    }

    private static void add_new_contact(){
        boolean contact_exists = false;

        System.out.println("Adding new Contact");

        System.out.println("Please enter contact's name: ");
        String new_name = user_input.next();
        System.out.println("Please enter contact's number: ");
        String new_number = user_input.next();
        System.out.println("Please enter contact's email: ");
        String new_email = user_input.next();

        if (new_name.equals("") || new_number.equals("") || new_email.equals("")) {
            System.out.println("Invalid, Please fill all fields");
            System.out.println("*******************");
            add_new_contact();
        }
        else {
            for (Contacts ctr: contacts_arraylist){
                if (ctr.getContact_name().equals(new_name)){
                    contact_exists = true;
                    System.out.println("Contact already exists");
                    ctr.get_contact_details();
                    System.out.println("*******************");
                }
            }

            if (contact_exists == false){
                Contacts new_contact = new Contacts(new_name, new_number, new_email);
                contacts_arraylist.add(new_contact);
                System.out.println("*******************");
            }
        }

        /*
        else {
            Contacts new_contact = new Contacts(new_name, new_number, new_email);
            contacts_arraylist.add(new_contact);
        }
        */

        option_select();
    }

    private static void contact_search(){
        boolean contact_exists = false;

        System.out.println("Please enter the contact name you want to search: ");
        String search_name = user_input.next();
        if (search_name.equals("")){
            System.out.println("Invalid, Please fill all fields");
            System.out.println("*******************");
            contact_search();
        }
        else {
            for (Contacts ctr: contacts_arraylist){
                if (ctr.getContact_name().equals(search_name)){
                    contact_exists = true;
                    ctr.get_contact_details();
                    System.out.println("*******************");
                }
            }

            if (contact_exists == false){
                System.out.println("Contact does not exist");
                System.out.println("*******************");
            }

        }

        option_select();
    }

    private static void delete_contact(){
        boolean contact_exists = false;

        System.out.println("Please enter the contact name you want to delete: ");
        String delete_name = user_input.next();

        if (delete_name.equals("")) {
            System.out.println("Please fill the field");
            System.out.println("*******************");
            delete_contact();
        }

        //The error happens after deletion
        else {
            for (Contacts ctr: contacts_arraylist){
                if (ctr.getContact_name().equals(delete_name)){
                    contact_exists = true;
                    //ctr.get_contact_details();
                    contacts_arraylist.remove(ctr);
                    System.out.println("Contact has been deleted");
                    System.out.println("*******************");
                    option_select();
                }
            }

            if (contact_exists == false) {
                System.out.println("Contact does not exist");
                System.out.println("*******************");
                option_select();
            }
        }

        option_select();
    }


    //Function methods - manage messages
    private static void show_messages() {
        messages_arraylist = new ArrayList<>();

        for (Contacts ctr: contacts_arraylist){
            messages_arraylist.addAll(ctr.getMessages_list());
        }

        if (messages_arraylist.size() > 0) {
            for (Messages ctr: messages_arraylist) {
                ctr.get_message_details();
                System.out.println("*******************");
            }
        }
        else {
            System.out.println("No messages.");
        }

        option_select();

    }

    //TODO Error here
    private static void send_message() {
        boolean contact_exists = false;

        System.out.println("Enter message recepient: ");
        String send_name = user_input.next();

        for (Contacts ctr: contacts_arraylist){
            if (ctr.getContact_name().equals(send_name)) {
                contact_exists = true;
            }
        }

        if (contact_exists == true){
            System.out.println("Message: ");
            String send_text = user_input.next();

            contact_id = contact_id + 1;

            Messages new_message = new Messages(send_text, send_name, contact_id);

            for (Contacts ctr: contacts_arraylist) {
                if (ctr.getContact_name().equals(send_name)) {
                    //Gets the message and puts it on the arraylist
                    ArrayList<Messages> new_message_arraylist = ctr.getMessages_list();
                    new_message_arraylist.add(new_message);
                    Contacts current_contact = ctr;
                    current_contact.setMessages_list(new_message_arraylist);

                    //Updates the contact arraylist
                    contacts_arraylist.remove(ctr);
                    contacts_arraylist.add(current_contact);
                }
            }
        }

        else if (contact_exists == false){
            System.out.println("Contact does not exist.");
            System.out.println("*******************");
        }

        option_select();
    }


    public static void main(String[] args) {

        contacts_arraylist = new ArrayList<>();

        //Greet the user
        System.out.println("Greetings mf");

        option_select();

    }

}