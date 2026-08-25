package module3;
import java.util.*;

public class ContactManager {
    public static void main(String[] args) {
        //create hashmap
        HashMap<String, Contact> contacts = new HashMap<>();

        //create contact objects and add them to the hashmap in the same line 
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("John Smith", new Contact("John Smith", "+1 541 265 3652"));
        contacts.put("Jane Smith", new Contact("Jane Smith", "+1 145 884 3651"));
        contacts.put("James Bond", new Contact("James Bond", "+1 001 466 1536"));
        contacts.put("Forrest Gump", new Contact("Forrest Gump", "+1 293 145 7815"));

        //search through for a contact. if found display details else display not found
        Contact found = contacts.get("Ada Lovelace");
        if(found != null)
        {
            System.out.println("Contact Found:");
            System.out.println(found);
        }
        else
        {
            System.out.println("Contact not found.");
        }

        //create arraylist and sort contacts by name
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        //print out all contacts
        System.out.println("\n=== All Contacts ===");
        for(Contact cont : sorted)
        {
            System.out.println(cont);
        }
    }
}
