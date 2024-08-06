class Solution {
    public String removeStars(String s) {
     
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!Character.isAlphabetic(cur)) {
                st.pop();
            } else {
                st.push(cur);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }
        return sb.toString();
    }
}