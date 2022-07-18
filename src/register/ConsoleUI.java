package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User interface of the application.
 */
public class ConsoleUI {
    /** register.Register of persons. */
    private ArrayRegister arrayRegister;
    
    /**
     * In JDK 6 use Console class instead.
//     * @see  readLine()
     */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * Menu options.
     */
    private enum Option {
        PRINT, ADD, UPDATE, REMOVE, FIND, EXIT
    };
    
    public ConsoleUI(ArrayRegister arrayRegister) {
        this.arrayRegister = arrayRegister;
    }
    
    public void run() {
        while (true) {
            switch (showMenu()) {
                case PRINT:
                    printRegister();
                    break;
                case ADD:
                    addToRegister();
                    break;
                case UPDATE:
                    updateRegister();
                    break;
                case REMOVE:
                    removeFromRegister();
                    break;
                case FIND:
                    findInRegister();
                    break;
                case EXIT:
                    return;
            }
        }
    }
    
    private String readLine() {
        //In JDK 6.0 and above Console class can be used
        //return System.console().readLine();
        
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }
    
    private Option showMenu() {
        System.out.println("Menu.");
        for (Option option : Option.values()) {
            System.out.printf("%d. %s%n", option.ordinal() + 1, option);
        }
        System.out.println("-----------------------------------------------");
        
        int selection = -1;
        do {
            System.out.println("Option: ");
            selection = Integer.parseInt(readLine());
        } while (selection <= 0 || selection > Option.values().length);
        
        return Option.values()[selection - 1];
    }

    private void printRegister() {
        for (int i = 0; i < arrayRegister.getSize(); i++) {
            System.out.println((i + 1) + ". " + arrayRegister.getPerson(i));
        }
    }
    
    private void addToRegister() {
        System.out.println("Enter Name: ");
        String name = readLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = readLine();

        arrayRegister.addPerson(new Person(name, phoneNumber));

    }

    private void updateRegister() {

        System.out.println("Enter index: ");
        int index = (Integer.parseInt(readLine()) - 1);
        System.out.println("Enter new Name: ");
        String newName = readLine();
        System.out.println("Enter new phone number: ");
        String newPhoneNumber = readLine();
        arrayRegister.getPerson(index).setName(newName);
        arrayRegister.getPerson(index).setPhoneNumber(newPhoneNumber);

    }

    private void findInRegister() {
        System.out.println("Find in register by entering name or phone number: ");

        String name = readLine();
        Pattern pt1 = Pattern.compile("([a-zA-Z]+)\\s([a-zA-Z]+)");
        Matcher mt1 = pt1.matcher(name);

        while(true) {
            if(mt1.matches()) {
                arrayRegister.findPersonByName(name);
                break;
            }
            if(!mt1.matches()) {
                String phoneNumber = readLine();
                Pattern pt2 = Pattern.compile("(\\d{4}|\\+\\d{3})\\s(\\d{3})\\s(\\d{3})");
                Matcher mt2 = pt2.matcher(phoneNumber);
                if (mt2.matches()){
                    arrayRegister.findPersonByPhoneNumber(phoneNumber);
                    break;
                }
            }
            throw new RuntimeException("Invalid name or phone number");
        }
    }
    
    private void removeFromRegister() {
        System.out.println("Enter index: ");
        int index = Integer.parseInt(readLine());
        Person person = arrayRegister.getPerson(index - 1);
        arrayRegister.removePerson(person);
    }
}
