
// 예제 1:
// 입력: s = “abcxyz123”, dict = [“abc”, “123”]
// 출력: “<b>abc</b>xyz<b>123</b>”
// 설명:
// dict에는 두 개의 단어 abc, 123이 있고 각 단어는 입력 s = “abcxyz123” 내에서 각각 일치합니다. 따라서 dict에서 주어진 단어들을 각각 bold tag로 감싼 문자열 “<b>abc</b>xyz<b>123</b>”를 리턴합니다.

// 예제 2:
// 입력: s = “abcxyz123”, dict = [“abc”, “xyz”]
// 출력: “<b>abcxyz</b>123”
// 설명:
// dict에는 두 개의 단어 abc, xyz가 있고 각 단어는 입력 s = “abcxyz123” 내에서 각각 일치하지만, 두 단어는 붙어있으므로 두 단어 모두를 하나의 bold tag로 감싼 문자열 “<b>abcxyz</b>123”을 리턴합니다.

// 예제 3:
// 입력: s = “aaabbcc”, dict = [“aaa”, “aab”, “bc”]
// 출력: “<b>aaabbc</b>c”
// 설명:
// dict에는 세 개의 단어 aaa, aab, bc가 있고 각 단어는 입력 s내에서 각각 일치하는 부분이 있지만 세 단어 모두 겹치거나 이어지는 부분이 있으므로 하나의 bold tag로 감싼 문자열 “<b>aaabbc</b>c”을 리턴합니다.

// 예제4:
// 입력: s = “aaabbccaabc”, dict = [“aaa”, “aab”, “bc”]
// 출력: “<b>aaabbc</b>c<b>aabc</b>”
// 설명:
// dict에는 세 개의 단어 aaa, aab, bc가 있고 각 단어는 입력 s내에서 각각 여러번 일치하는 부분이 있고 세 단어 모두 겹치거나 이어지는 부분이 있으므로 각각의 매칭되는 chunk를 각각 하나의 bold tag로 감싼 문자열 “<b>aaabbc</b>c<b>aabc</b>”을 리턴합니다.

// 제약사항
// 1 <= dict.size <= 100
// dict에는 중복된 단어가 주어지지 않습니다.
// 모든 입력에 쓰이는 string은 1000자 이하입니다.

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