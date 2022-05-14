package Week10.Task4;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;


public class VowelCount
{

    public static void main(String[] args) throws SQLException {
        Scanner kybd = new Scanner(System.in);

        System.out.println("Enter a sentence: > ");
        String sentence = kybd.nextLine();

        VowelCounter vowelCounter = new VowelCounter(sentence);

        System.out.println("\nPrinting the map of the vowels of the sentence");
        vowelCounter
                .getVowelCounts()
                .entrySet()
                .stream()
                .forEach(entry -> System.out.printf("%c: %d\n", entry.getKey(), entry.getValue()));
        new VowelTallyGateway().updateVowelTally(vowelCounter.getVowelCounts());

        System.out.println("\nPrinting the map of vowels from the database");
        Map<Character, Long> tally = new VowelTallyGateway().getVowelTallies();
        tally.entrySet()
                .stream()
                .forEach(vowel -> System.out.printf("\nvowel : %-3s tally : %-3d", vowel.getKey(), vowel.getValue()));
    }

}