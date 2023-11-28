public class Messages {

    private String message;
    private String message_contact_name;
    private int contact_id;

    //Constructor
    public Messages(String message, String message_contact_name, int contact_id) {
        this.message = message;
        this.message_contact_name = message_contact_name;
        this.contact_id = contact_id;
    }

    //Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage_contact_name() {
        return message_contact_name;
    }

    public void setMessage_contact_name(String message_contact_name) {
        this.message_contact_name = message_contact_name;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    //Methods
    public void get_message() {
        System.out.println("Contact Name: " + this.message_contact_name);
        System.out.println("Message: " + this.message);
    }

}
