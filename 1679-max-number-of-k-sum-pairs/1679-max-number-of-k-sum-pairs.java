import java.util.Arrays;

class Solution {
    public int maxOperations(int[] nums, int k) {
        // 배열을 정렬
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int operations = 0;

        // 두 포인터를 사용하여 배열 탐색
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (sum == k) {
                // 합이 k이면 작업을 수행하고 두 포인터를 이동
                operations++;
                left++;
                right--;
            } else if (sum < k) {
                // 합이 k보다 작으면 더 큰 값을 찾기 위해 left 이동
                left++;
            } else {
                // 합이 k보다 크면 더 작은 값을 찾기 위해 right 이동
                right--;
            }
        }
        
        return operations;
    }
}
