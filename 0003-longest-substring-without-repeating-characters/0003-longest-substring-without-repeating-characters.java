class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        
        // Map ASCII characters to their last seen index + 1
        int[] lastSeen = new int[128];
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // Move left pointer past the last occurrence of the current character
            left = Math.max(left, lastSeen[currentChar]);
            
            // Calculate current window length and update max length
            maxLength = Math.max(maxLength, right - left + 1);
            
            // Store index + 1 to distinguish between index 0 and default 0 initialization
            lastSeen[currentChar] = right + 1;
        }
        
        return maxLength;
    }
}