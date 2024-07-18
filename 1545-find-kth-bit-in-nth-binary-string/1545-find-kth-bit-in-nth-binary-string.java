class Solution {
    public char findKthBit(int n, int k) {
        // 초기 문자열 S1은 "0"
        StringBuilder sb = new StringBuilder("0");
        int loopCnt = 1;
        
        Map<Integer, StringBuilder> map = new HashMap<>();
        map.put(loopCnt, sb);
        
        while (loopCnt < n) {
            loopCnt++;
            
            // invert와 reverse 수행
            StringBuilder prev = new StringBuilder(map.get(loopCnt - 1));
            StringBuilder inverted = new StringBuilder();
            
            for (int i = 0; i < prev.length(); i++) {
                if (prev.charAt(i) == '0') {
                    inverted.append('1');
                } else {
                    inverted.append('0');
                }
            }
            
            inverted.reverse();
            
            // 새로운 문자열 생성
            sb = new StringBuilder(map.get(loopCnt - 1))
                    .append('1')
                    .append(inverted);
            
            map.put(loopCnt, sb);
        }
        
        // k번째 비트를 반환
        return map.get(n).charAt(k - 1);
    }
    
}