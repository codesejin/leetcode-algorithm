class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        // 연속된 공백을 하나의 구분자로 처리
        String[] splited = s.trim().split("\\s+");

        // 배열을 뒤에서부터 순서대로 append
        for (int i = splited.length - 1; i >= 0; i--) {
            sb.append(splited[i]);

            // 마지막 단어가 아닌 경우만 공백 추가
            if (i > 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
