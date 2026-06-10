import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private ArrayList<String> history = new ArrayList<>();

   public void addTransaction(String transaction) {

    LocalDateTime now = LocalDateTime.now();

    DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a");

    String dateTime = now.format(formatter);

    history.add(dateTime + " | " + transaction);
}

    public void showHistory() {

    if(history.isEmpty()) {
        System.out.println("\nNo Transactions Yet.");
        return;
    }

    System.out.println("\n========== TRANSACTION HISTORY ==========");

    for(String t : history) {
        System.out.println(t);
    }

    System.out.println("=========================================");
}
}