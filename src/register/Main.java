package register;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ArrayRegister arrayRegister = new ArrayRegister(5);

        arrayRegister.addPerson(new Person("Matej Regec" , "0907 811 417"));
        arrayRegister.addPerson(new Person("Eduard Remetei" , "+421 855 255"));
        arrayRegister.addPerson(new Person("Zuzana Michlikova" , "0918 111 216"));

        ConsoleUI ui = new ConsoleUI(arrayRegister);
        ui.run();
    }
}
