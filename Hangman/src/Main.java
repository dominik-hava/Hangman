import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int hangPhase = 0;
        int player1WinCount = 0;
        int player2WinCount = 0;
        int correctGuess = 0;
        String wordToGuess;
        String guessingCharOrWord;
        String usedChars = "";
        String player1Name;
        String player2Name;
        boolean continuePlaying;

        System.out.println("Vítej ve hře Šibenice.\n");
        System.out.print("Zadejte jméno 1. hráče: ");
        player1Name = scanner.next().trim();
        System.out.print("Zadejte jméno 2. hráče: ");
        player2Name = scanner.next().trim();

        do {
            if (player1WinCount + player2WinCount % 2 == 0)
                System.out.println("Dobře, hraje hráč " + player1Name + ".");
            else
                System.out.println("Dobře, hraje hráč " + player2Name + ".");

            System.out.print("Zadej libovolné slovo (slovo musí obsahovat minimálně 3 a maximálně 18 písmen): ");
            wordToGuess = scanner.next();
            
            while (wordToGuess.length() < 2 || wordToGuess.length() > 19) {
                System.out.print("Neplatné slovo! Zadej ještě jednou: ");
                wordToGuess = scanner.next();
            }

            if (player1WinCount + player2WinCount + 1 % 2 == 0)
                System.out.println("Dobře, nyní hráč " + player1Name + " zadává písmenka popřípadě slova");
            else
                System.out.println("Dobře, nyní hráč " + player2Name + " zadává písmenka popřípadě slova");

            System.out.print("Nyní zadej písmeno nebo slovo: ");
            guessingCharOrWord = scanner.next();

            System.out.println("Chcete pokračovat?");
            if (askToContinue(scanner).equals("ano"))
                continuePlaying = true;
            else
                continuePlaying = false;

        } while (continuePlaying);
    }

    public static String askToContinue(Scanner scanner) {
        String input = scanner.next();
        while (!input.equals("ne") && !input.equals("ano")) {
            scanner.nextLine();
            System.out.println("Zadejte pouze \"ano\" nebo \"ne\"");
            input = scanner.next();
        }
        return input;
    }
}
