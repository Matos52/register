package register;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Register register = new Register(5);

        register.addPerson(new Person("Matej Regec" , "0907 811 417"));
        register.addPerson(new Person("Eduard Remetei" , "+421 855 255"));
        register.addPerson(new Person("Zuzana Michlikova" , "0918 111 216"));

        ConsoleUI ui = new ConsoleUI(register);
        ui.run();
    }
}
