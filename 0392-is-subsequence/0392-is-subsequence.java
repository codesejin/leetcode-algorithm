class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) {
            return true;
        }
        int sidx = 0, tidx = 0;

        while (sidx < s.length() && tidx < t.length()) {
            if (s.charAt(sidx) == t.charAt(tidx)) {
                sidx++;  // s의 현재 문자가 t에서 발견되면 sidx를 증가
            }
            tidx++;  // t의 다음 문자를 확인
        }

        return sidx == s.length();  // s의 모든 문자를 확인했다면 true, 아니면 false
    }
}