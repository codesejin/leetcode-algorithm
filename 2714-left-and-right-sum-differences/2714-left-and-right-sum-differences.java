class Solution {
    public int[] leftRightDifference(int[] nums) {

        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        // 왼쪽 합계 계산
        leftSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i];
        }

        // 오른쪽 합계 계산
        rightSum[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }

        // 결과 배열 계산
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return result;
    }
}