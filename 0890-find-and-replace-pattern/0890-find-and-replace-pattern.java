import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        
        return result;
    }

    private boolean matches(String word, String pattern) {
        int[] mapWord = new int[128];
        int[] mapPattern = new int[128];

        for (int i = 0; i < word.length(); i++) {
            char wChar = word.charAt(i);
            char pChar = pattern.charAt(i);

            // If last seen positions don't match, bijection is violated
            if (mapWord[wChar] != mapPattern[pChar]) {
                return false;
            }

            // Store index + 1 (1-based index) to distinguish from default 0 initialization
            mapWord[wChar] = i + 1;
            mapPattern[pChar] = i + 1;
        }

        return true;
    }
}