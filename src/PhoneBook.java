import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, Contact> storage = new HashMap<>();

    public boolean addContact(Contact contact) {
        storage.put(contact.getPhone(), contact);
        return true;
    }

    public Contact findByPhone(String phone) {
        return storage.get(phone);
    }

    public static Contact createContact(String name, String phone) {
        return new Contact(name, phone);
    }

}
