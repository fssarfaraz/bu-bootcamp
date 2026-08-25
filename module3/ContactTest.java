package module3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 
 
public class ContactTest {
 
 private Contact contact; 
 
  @BeforeEach
  void setUp() {
    contact = new Contact("Ada Lovelace", "+1 617 555 0101");
  } 
 
  @Test
  void getName_returnsCorrectName() {
    assertEquals("Ada Lovelace", contact.getName());
  } 
 
  @Test
  void getPhone_returnsCorrectPhone() {
    assertEquals("+1 617 555 0101", contact.getPhone());
  } 
 
  @Test
  void toString_containsBothFields() {
    assertTrue(contact.toString().contains("Ada Lovelace"));
    assertTrue(contact.toString().contains("+1 617 555 0101"));
  }

  @Test
  void constructor_independentDespiteSameName(){
    //create a new contact with the same name to test if they share memory cause of the shared name
    Contact contact2 = new Contact("Ada Lovelace", "+62 541 522 7841");

    //making sure that both contact objects have the same name
    if(contact.getName() == contact2.getName())
    {
        //change the second object
        contact2 = new Contact("Ada Lovelace", "+62 748 153 6510");
    }
    //verify that the first object remains unchanged
    assertEquals("+1 617 555 0101", contact.getPhone());
  }

  @Test
  void toString_displaysEmptyInput(){
    //create a new contact with empty strings
    Contact empContact = new Contact("", "");

    //make sure that toString displays only the delimiter
    assertEquals(" | ", empContact.toString());
  }
} 