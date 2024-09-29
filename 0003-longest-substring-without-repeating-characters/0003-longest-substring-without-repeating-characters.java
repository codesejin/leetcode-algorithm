class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0, result = 0;
        
        while (r < s.length()) {
            char c = s.charAt(r++);
            
            while (set.contains(c)) {
                char t = s.charAt(l++);
                set.remove(t);
            }
            
            set.add(c);
            
            result = Math.max(result, r-l);
        }
        return result;
    }
}