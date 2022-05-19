package Week11.Week11A.VowelCount;

import Week11.Week11A.VowelCount.database.VowelTallyGateway;

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
        Map<Character,Long> map=vowelCounter.getVowelCounts();


        System.out.println("\nPrinting the map of vowels");
        map.forEach((key, value) -> System.out.printf("%c: %d\n", key, value));
        
        System.out.println("\nPrinting the map of vowels from the list of vowels");
        VowelCounter
                .getVowels()
                .forEach(vowel -> System.out.printf("%c: %d\n", vowel, vowelCounter.getCountForVowel(vowel)));

        VowelTallyGateway vowelTallyGateway=VowelTallyGateway.getInstance();
        vowelTallyGateway.updateVowelTally(map);

        System.out.println("\nPrinting the map of vowels from database");
        vowelTallyGateway.getVowelTallies().forEach((key,value) -> System.out.printf("%c: %d\n", key,value));

    }

}
