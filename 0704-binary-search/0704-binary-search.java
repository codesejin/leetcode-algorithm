class Solution {
    public int search(int[] nums, int target) {
        int result = -1;
        int left = 0;
        int right = nums.length -1;
        
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}