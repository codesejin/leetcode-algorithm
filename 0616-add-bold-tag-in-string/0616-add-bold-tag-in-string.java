class Solution {
    public String addBoldTag(String s, String[] words) {
        boolean[] bold = new boolean[s.length()]; // 마킹 배열
        
        for (int i = 0; i < s.length(); i++) {
            for (String word : words) {
                // startsWith(String prefix, int toffset) 
                if(s.startsWith(word, i)) {
                    for (int j = 0; j < word.length(); j++) {
                        bold[j + i] = true;
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        
        while (idx < s.length()) {
            if (!bold[idx]) {
                sb.append(s.charAt(idx++));
                continue;
            }
            sb.append("<b>");
            while (idx < s.length() && bold[idx]) {
                sb.append(s.charAt(idx++));
            }
            sb.append("</b>");
        }
        return sb.toString();
    }
}