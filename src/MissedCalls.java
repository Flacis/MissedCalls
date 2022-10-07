import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {
    private static final DateTimeFormatter DEFAULT_DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    private Map<LocalDateTime, String> storage = new TreeMap<>();

    public void addMissedCalls(String phone) {
        storage.put(LocalDateTime.now(), phone);
    }

    public String toString(PhoneBook phoneBook) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<LocalDateTime, String> missedCall : storage.entrySet()) {
            final Contact contact = phoneBook.findByPhone(missedCall.getValue());
            sb
                    .append(
                            DEFAULT_DATE_FORMAT.format(
                                    missedCall.getKey()))
                    .append("\t")
                    .append(
                            contact != null ? contact.getName() : missedCall.getValue())
                    .append("\n");
        }
        return sb.toString();
    }
}
