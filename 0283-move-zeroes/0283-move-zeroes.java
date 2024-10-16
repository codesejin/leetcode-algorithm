class Solution {
    public void moveZeroes(int[] nums) {

        if (nums.length <= 1) {
            return;
        }

        int left = 0, right = 0;

        // 오른쪽 포인터를 이동하면서 0이 아닌 값을 왼쪽에 채워 넣음
        while (right < nums.length) {
            if (nums[right] != 0) {
                // 0이 아닌 값을 찾으면 왼쪽과 교환
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;  // 왼쪽 포인터만 증가시킴
            }
            right++;  // 오른쪽 포인터는 항상 증가
        }
    }
}
