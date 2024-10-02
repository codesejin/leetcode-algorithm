class Solution {
        static final Map<Character, List<Character>> dic = new HashMap<>();
    static {
        dic.put('0', List.of());
        dic.put('1', List.of());
        dic.put('2', List.of('a', 'b', 'c'));
        dic.put('3', List.of('d', 'e', 'f'));
        dic.put('4', List.of('g', 'h', 'i'));
        dic.put('5', List.of('j', 'k', 'l'));
        dic.put('6', List.of('m', 'n', 'o'));
        dic.put('7', List.of('p', 'q', 'r', 's'));
        dic.put('8', List.of('t', 'u', 'v'));
        dic.put('9', List.of('w', 'x', 'y', 'z'));
    }
    
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        // 현재 자리 0, 빈 문자열 이용 DFS 시작
        dfs(result, digits, 0, new StringBuilder());
        return result;
    }

    private void dfs(List<String> result, String digits, int index, StringBuilder path) {
        // 디버깅을 위한 출력 추가
      // System.out.println(">>> 현재 인덱스: " + index + ", 현재까지 구성된 문자열: " + path.toString() + " <<<");

        // 끝까지 탐색했으면 결과를 저장하고 리턴
        if (path.length() == digits.length()) {
            result.add(String.valueOf(path));
        //    System.out.println("   [완성된 문자열: " + path.toString() + "] 결과 리스트에 추가됨");
            return;
        }

        // 현재 자리 숫자에 해당하는 모든 문자열 탐색
        for (Character c : dic.get(digits.charAt(index))) {
        //    System.out.println("현재 dic의 key로 설정된 숫자: " + digits.charAt(index) + ", 탐색 중인 문자: " + c);
            // 현재 자리 +1, 지금까지 구성된 문자열 path 이용 재귀 DFS
            dfs(result, digits, index + 1, new StringBuilder(path).append(c));
        }
    }
}
