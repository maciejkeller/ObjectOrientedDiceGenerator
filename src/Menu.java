import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private final Scanner SCANNER = new Scanner(System.in);
    private final Dice D4 = new Dice(4);
    private final Dice D6 = new Dice(6);
    private final Dice D8 = new Dice(8);
    private final Dice D10 = new Dice(10);
    private final Dice D20 = new Dice(20);
    private final Dice D100 = new Dice(100);


    public void welcomeScreen() {
        System.out.println("Witaj w generatorze rzutu kością.");
        promptEnterKey();
    }

    public void printOptions() {
        System.out.println("Wybierz opcję:" +
                "\n 1. Rzuć kością czterościenną (k4)" +
                "\n 2. Rzuć kością sześciościenną (k6)" +
                "\n 3. Rzuć kością ośmiościenną (k8)" +
                "\n 4. Rzuć kością dziesięciościenną (k10)" +
                "\n 5. Rzuć kością dwudziestościenną (k20)" +
                "\n 6. Rzuć kością stuścienną (k100)" +
                "\n 7. Wyjdź");
    }

    public String readOption() {
        String option = SCANNER.next();
        return option;
    }

    public void showResult(Dice dice) {
        System.out.println("Twój wynik to " + dice.throwDice());
        System.out.println("Czy chcesz rzucić jeszcze raz tą kością? [T/N]");
    }

    public void throwAgain(Dice dice) {
        while (readOption().equalsIgnoreCase("t")) {
            showResult(dice);
        }
    }

    public void endProgram() {
        System.out.println("Koniec programu");
        System.exit(-1);
    }

    public static void promptEnterKey() {
        System.out.println("Żeby kontynuować wciśnij ENTER.");
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMenu() {
        while (true) {
            printOptions();
            switch (readOption()) {
                case "1":
                    showResult(D4);
                    throwAgain(D4);
                    break;
                case "2":
                    showResult(D6);
                    throwAgain(D6);
                    break;
                case "3":
                    showResult(D8);
                    throwAgain(D8);
                    break;
                case "4":
                    showResult(D10);
                    throwAgain(D10);
                    break;
                case "5":
                    showResult(D20);
                    throwAgain(D20);
                    break;
                case "6":
                    showResult(D100);
                    throwAgain(D100);
                    break;
                case "7":
                    endProgram();
                default:
                    System.out.println("Nieprawidłowa opcja.");
            }
        }
    }
}
