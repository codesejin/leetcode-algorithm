class Solution {
    public int heightChecker(int[] heights) {
        int[] sortedHeights = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sortedHeights);
        return (int) IntStream.range(0, heights.length)
                              .filter(i -> heights[i] != sortedHeights[i])
                              .count();
    }
}