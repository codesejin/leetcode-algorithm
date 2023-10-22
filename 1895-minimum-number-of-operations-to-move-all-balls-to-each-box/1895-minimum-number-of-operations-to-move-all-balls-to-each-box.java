class Solution {
    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];
        char[] charArray = boxes.toCharArray();
        for (int i = 0; i < boxes.length(); i++) {
            int abs = 0;
            for (int j = 0; j < boxes.length(); j++) {
                if (charArray[j] == '1'){
                    abs += Math.abs(i - j);
                }
            }
            answer[i] = abs;
        }
        return answer;
    }
}