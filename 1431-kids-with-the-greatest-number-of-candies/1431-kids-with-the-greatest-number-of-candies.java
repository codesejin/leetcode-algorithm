import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        
        // 배열에서 가장 큰 사탕 수를 찾음
        int maxCandies = 0;
        for (int candy : candies) {
            if (candy > maxCandies) {
                maxCandies = candy;
            }
        }
        
        // 각 아이의 사탕 수에 extraCandies를 더한 값이 최대 사탕 수 이상인지 확인
        for (int candy : candies) {
            if (candy + extraCandies >= maxCandies) {
                result.add(true);  // 최대 사탕 수 이상이면 true
            } else {
                result.add(false); // 그렇지 않으면 false
            }
        }
        
        return result;
    }
}
