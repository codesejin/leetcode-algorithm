class Solution {
        // n == nums.length랑 같다는 제약 조건 확인 !!!
    public int missingNumber(int[] nums) {

        int len = nums.length;
        int max = 0 ;
        for (int i : nums) {
            max = Math.max(max, i);
        }

        if (max != len) max = len;
		int expected = IntStream.range(0, max+1).sum();
		int actual = Arrays.stream(nums).sum();
		return expected - actual;
	}
}