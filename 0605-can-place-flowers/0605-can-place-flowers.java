class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        
        for (int i = 0; i < length; i++) {
            // 현재 위치가 빈 자리이며 양 옆도 비어 있는지 확인
            if (flowerbed[i] == 0) {
                // 왼쪽과 오른쪽이 비어 있거나 범위를 벗어난 경우만 꽃을 심을 수 있음
                boolean leftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                boolean rightEmpty = (i == length - 1) || (flowerbed[i + 1] == 0);

                if (leftEmpty && rightEmpty) {
                    // 꽃을 심고, 해당 자리를 1로 표시
                    flowerbed[i] = 1;
                    n--;  // 남은 꽃의 수를 줄임

                    // 모든 꽃을 다 심었다면 true 반환
                    if (n == 0) {
                        return true;
                    }
                }
            }
        }
        
        // 모든 자리를 탐색했음에도 꽃을 다 심지 못했다면 false 반환
        return n <= 0;
    }
}
