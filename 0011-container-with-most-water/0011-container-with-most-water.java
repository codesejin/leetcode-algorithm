class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // 두 포인터가 가리키는 선들의 높이 중 더 작은 것을 선택
            int minHeight = Math.min(height[left], height[right]);
            // 현재 용기의 면적 계산
            int currentArea = minHeight * (right - left);
            // 최대 면적 업데이트
            maxArea = Math.max(maxArea, currentArea);

            // 더 짧은 선 쪽의 포인터를 이동
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
