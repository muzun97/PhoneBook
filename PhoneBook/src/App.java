
import java.io.FileNotFoundException;


public class App {
    public static void main(String[] args) throws FileNotFoundException {
        PhoneBook phoneBook = new PhoneBook("PhoneNumber.txt");

        phoneBook.printContacts();

        phoneBook.call("Anton");
        phoneBook.call("Anton");
        phoneBook.call("Anton");
        phoneBook.call("Qna");
        phoneBook.call("Qna");
        phoneBook.call("Mustafa");

        phoneBook.outgoingCalls();




    }
}
