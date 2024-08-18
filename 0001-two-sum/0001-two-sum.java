class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        
        while (left < nums.length - 1) {
            for (int right = left + 1; right < nums.length; right++) {
                if ((nums[left] + nums[right]) == target) {
                    result[0] = left;
                    result[1] = right;
                    return result; // 해결책을 찾으면 반환
                }
            }
            left++;
        }
        return result;
    }
}