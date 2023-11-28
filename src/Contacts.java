import java.util.ArrayList;

public class Contacts {

    private String contact_name;
    private String contact_no;
    private String email;
    private ArrayList<Messages> messages_list;

    //Constructors
    //Two constructors are used because a newly made Contact will not have a message to come along with it
    public Contacts(String contact_name, String contact_no, String email, ArrayList<Messages> messages) {
        this.contact_name = contact_name;
        this.contact_no = contact_no;
        this.email = email;
        this.messages_list = messages;
    }

    public Contacts(String contact_name, String contact_no, String email) {
        this.contact_name = contact_name;
        this.contact_no = contact_no;
        this.email = email;
        this.messages_list = new ArrayList<>();
    }

    //Getters and Setters
    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Messages> getMessages_list() {
        return messages_list;
    }

    public void setMessages_list(ArrayList<Messages> messages_list) {
        this.messages_list = messages_list;
    }

    //Methods
    public void get_contacts() {
        System.out.println("Name: " + this.contact_name);
        System.out.println("Contact Number: " + this.contact_no);
        System.out.println("Email Address: " + this.email);
    }

}
