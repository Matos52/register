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
    private Register register;
    
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
    
    public ConsoleUI(Register register) {
        this.register = register;
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
    
    //TODO: Implement the method printRegister
    private void printRegister() {
        for (int i = 0; i < register.getSize(); i++) {
            System.out.println((i + 1) + ". " + register.getPerson(i));
        }
//        throw new UnsupportedOperationException("Method printRegister not yet implemented");
    }
    
    private void addToRegister() {
        System.out.println("Enter Name: ");
        String name = readLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = readLine();

        register.addPerson(new Person(name, phoneNumber));

    }
    
    //TODO: Implement the method updateRegister
    private void updateRegister() {

        System.out.println("Enter index: ");
        int index = (Integer.parseInt(readLine()) - 1);
        System.out.println("Enter new Name: ");
        String newName = readLine();
        System.out.println("Enter new phone number: ");
        String newPhoneNumber = readLine();
        register.getPerson(index).setName(newName);
        register.getPerson(index).setPhoneNumber(newPhoneNumber);

//        throw new UnsupportedOperationException("Method updateRegister not yet implemented");
    }
    
    //TODO: Implement the method findInRegister
    private void findInRegister() {

        System.out.println("Find in register by entering name or phone number: ");

        String name = readLine();
        Pattern pt1 = Pattern.compile("([a-zA-Z]+)\\s([a-zA-Z]+)");
        Matcher mt1 = pt1.matcher(name);

        while(true) {
            if(mt1.matches()) {
                register.findPersonByName(name);
                break;
            }
            if(!mt1.matches()) {
                String phoneNumber = readLine();
                Pattern pt2 = Pattern.compile("(\\d{4}|\\+\\d{3})\\s(\\d{3})\\s(\\d{3})");
                Matcher mt2 = pt2.matcher(phoneNumber);
                if (mt2.matches()){
                    register.findPersonByPhoneNumber(phoneNumber);
                    break;
                }
            }
            throw new RuntimeException("Invalid name or phone number");
        }

//        throw new UnsupportedOperationException("Method findInRegister not yet implemented");
    }
    
    private void removeFromRegister() {
        System.out.println("Enter index: ");
        int index = Integer.parseInt(readLine());
        Person person = register.getPerson(index - 1);
        register.removePerson(person);
    }

}
