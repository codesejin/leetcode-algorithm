class Solution {
    // 키가 오름차순으로 서야한다
    public int heightChecker(int[] heights) {
        int[] sortedHeights = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sortedHeights);
        return (int) IntStream.range(0, heights.length)
                              .filter(i -> heights[i] != sortedHeights[i])
                              .count();
    }
}