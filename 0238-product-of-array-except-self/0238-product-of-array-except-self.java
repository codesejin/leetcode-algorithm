class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // 1. 왼쪽 곱 배열 계산
        result[0] = 1;  // 첫 번째 원소는 왼쪽에 아무것도 없으므로 1
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // 2. 오른쪽 곱을 계산하며 결과에 바로 반영
        int rightProduct = 1;  // 오른쪽 끝의 초기 값
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
