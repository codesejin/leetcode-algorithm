class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] answer = new int[nums.length];
        List<Integer> before = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> after = new ArrayList<>();
        for (int x : nums) {
            if (x < pivot) {
                before.add(x);
            } else if (x > pivot) {
                after.add(x);
            } else {
                mid.add(x);
            }
        }
        int midIdx = 0, afterIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= before.size() -1) {
                answer[i] = before.get(i);
            } else if (i > before.size()-1 && i <= before.size() + mid.size() - 1) {
                answer[i] = mid.get(midIdx++);
            } else if (i > before.size() + mid.size() - 1) {
                answer[i] = after.get(afterIdx++);
            }
        }
        return answer;
    }
}