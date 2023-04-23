import java.rmi.StubNotFoundException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author 21MHavaD
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HangMan hangMan = new HangMan();
        String testedChars = "";
        int hangPhase = 0;
        int winCount = 0;
        int guessedChar = 0;
        boolean continuePlaying;

        //Dodělat použitá písmenka array a spravit kód
        //Negunguje zatím nevím proč

        System.out.println("Vítej ve hře Šibenice.\n");

        System.out.println("\tV této hře budou hrát dva hráči. První hráč zadá libovolné slovo.");
        System.out.println("Dále bude hráč dva zkouše písmenka jestli slovo, které zadal první hráč, obshauje dané písmenko.");
        System.out.println("Pokud si bude hráč dva jist, že ví které je to, může vybrat možnost hádat slovo a zkusí uhádnout. Pokud se mu to podaří, hráč dva vyhrává.");
        System.out.println("Pozor!! Pokud hráč dva zadá špatné písmenko postaví se 1. z 5 část šibenice a pokud se postaví celá hráč dva vyhrává.");
        System.out.println("Pokud hrač dva zkusí uhádnout celé slovo a neuhádne automaticky postaví celou šibenici.\n");

        System.out.print("První hráč zadá slovo nebo slovní spojení");

        do {
            do {
                System.out.println(" (Slovo musí obsahovat minimálně 3 písmenka): ");
                hangMan.setWordToGuess(scanner.next().toLowerCase());
            }while (hangMan.getWordToGuess().length()<3);

            char[] hiddenWord = new char[hangMan.getWordToGuess().length()];
            
            for (int i=0; i<hangMan.getWordToGuess().length(); i++){
                if (hangMan.getWordToGuess().charAt(i) != ' '){
                    hiddenWord[i] = '_';
                }
                else hiddenWord[i] = ' ';
            }
            hangMan.setWordToGuess(hangMan.getWordToGuess().replace(" ", ""));

            System.out.println("Skvěle nyní druhý hráč bude zadávat písmenka.");
            while (true) {
                System.out.print("Zadej písmenko nebo celé slovo: ");
                hangMan.setGuessingWord(scanner.next().toLowerCase());

                if (hangMan.testCharOrWord(hangMan.getGuessingCharacter(), hiddenWord, hangMan.getWordToGuess())) {
                    if (hangMan.isWord) {
                        winCount++;
                        System.out.println("\n\nGratuluji, slovo si uhádl.");
                        break;
                    } else {
                        guessedChar++;
                        System.out.println(MessageFormat.format("\n{0}\n\nSkvěle slovo obsahuje písmenko: {1}", HangManDesign.printHangMan(hangPhase), hangMan.getGuessingCharacter(),hangMan.getGuessingCharacter()));
                    }
                } else {
                    hangPhase++;
                    if (hangMan.isWord){
                        System.out.println("\nKončís!!!");
                        break;
                    }
                    else if (hangPhase < 6) {
                        System.out.println(MessageFormat.format("\n{0}\n\nBohužel slovo neobsahuje písmenko. {1}", HangManDesign.printHangMan(hangPhase),hangMan.getGuessingCharacter()));

                    } else {
                        System.out.println(MessageFormat.format("\n{0}\n\nBohužel, prohrál si, máš 5 špatně uhádnutých písenek.", HangManDesign.printHangMan(hangPhase)));
                        break;
                    }
                }
                System.out.println();
                System.out.println(hiddenWord);

                if (guessedChar == hangMan.getWordToGuess().length()){
                    System.out.println("Skvěle, myslím že teď už by si slovo uhádl, takže rovnou vyhráváš.");
                    winCount++;
                    break;
                }
            }

            System.out.printf("Počet výher: %d.\n",winCount);
            System.out.println("Chcete hrát znovu? (Ano/Ne)");
            while (true) {
                String input = scanner.next();
                if (input.equalsIgnoreCase("ano")) {
                    continuePlaying = true;
                    break;
                } else if (input.equalsIgnoreCase("ne")){
                    continuePlaying = false;
                    break;
                }
                else System.out.println("Zadejte platnou hodnotu!");
            }

        } while (continuePlaying);
    }
}