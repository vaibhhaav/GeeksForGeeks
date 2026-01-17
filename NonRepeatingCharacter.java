import java.util.*;

class Solution {
    private static final int MAX_CHAR = 26;
    
    public char nonRepeatingChar(String s) {
        int[] freq = new int[MAX_CHAR];
        
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] == 1) {
                return c;
            }
        }
        
        return '$';
    }
}
