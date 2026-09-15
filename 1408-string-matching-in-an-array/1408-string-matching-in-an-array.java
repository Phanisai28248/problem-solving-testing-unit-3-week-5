import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        // Sort words by length in ascending order
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // If words[i] is a substring of a longer word words[j]
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // Stop searching once matched
                }
            }
        }

        return result;
    }
}