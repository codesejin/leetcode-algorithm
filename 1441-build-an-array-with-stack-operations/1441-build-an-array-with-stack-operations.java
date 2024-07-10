class Solution {
    static final String PUSH = "Push";
    static final String POP = "Pop";
    
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int targetIdx = 0;

        for (int i = 1; i <= n && targetIdx < target.length; i++) {
            st.push(i);
            result.add(PUSH);
            if (i == target[targetIdx]) {
                targetIdx++;
            } else {
                st.pop();
                result.add(POP);
            }
        }

        return result;
    }
}