import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class StringVowels {
    private static final Set<Character> VOWELS = new HashSet<>();

    public static void main(String[] args) {
        String input = "aibc";
        List<String> result = findVowelCombinations(input);

        System.out.println("Vowel combinations that start and end with a vowel:");
        for (String combination : result) {
            System.out.println(combination);
        }
    }

    // Method to find and filter the word combinations that start and end with a vowel
    public static List<String> findVowelCombinations(String input) {
        List<String> results = new ArrayList<>();
        char[] chars = input.toCharArray();
        boolean[] used = new boolean[chars.length];
        possibleCombinations(results, new StringBuilder(), chars, used);
        return results;
    }

    // This Recursive method used to generate all the possible combinations in the given string
    private static void possibleCombinations(List<String> results, StringBuilder current, char[] chars, boolean[] used) {
        if (current.length() == chars.length) {
            if (isVowel(current.charAt(0)) && isVowel(current.charAt(current.length() - 1))) {
                results.add(current.toString());
            }
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            current.append(chars[i]);
            possibleCombinations(results, current, chars, used);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }

    // Method to check if a character is a vowel
    private static boolean isVowel(char c) {
        char[] vowelsArray = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (char vowel : vowelsArray) {
            VOWELS.add(vowel);
        }
        return VOWELS.contains(c);
    }
}




