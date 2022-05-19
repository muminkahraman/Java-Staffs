package Week11.Week11A.VowelCount;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public final class VowelCounter
{

    private static final Collection<Character> vowels = Arrays.asList('A', 'E', 'I', 'O', 'U');

    private final Map<Character, Long> vowelCount;
    private final String sentence;

    public VowelCounter(String sentence)
    {
        this.sentence = sentence;
        vowelCount
                = sentence.toUpperCase()
                        .chars()
                        .filter(c -> vowels.contains((char) c))
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
    
    public Long getCountForVowel(char vowel)
    {
        return vowelCount.getOrDefault(vowel, 0L);
    }

    public String getSentence()
    {
        return sentence;
    }

    public Map<Character, Long> getVowelCounts()
    {
        return vowelCount;
    }

    public static Collection<Character> getVowels()
    {
        return vowels;
    }
}
