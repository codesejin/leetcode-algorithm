class Solution {
    // 1. 기존의 두 문자를 서로 교환한다. -> 기존 문자열 위치 변경
    // 2. 기존의 한 문자를 다른 문자로 변환하고, 다른 문자도 동일하게 변환한다. -> 기존 문자열 빈도 변경

    public boolean closeStrings(String word1, String word2) {
        // 문자열 길이가 다를 경우
        if (word1.length() != word2.length()) return false;
        // 서로 가진 문자가 다를 경우
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for(char c : word1.toCharArray()) {
            set1.add(c);
        }
        for(char c : word2.toCharArray()) {
            set2.add(c);
        }
        if (!set1.equals(set2)) return false;

        // 각 문자의 빈도수를 확인
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }

        // 빈도수 배열을 정렬하여 비교
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1, freq2);
    }
}