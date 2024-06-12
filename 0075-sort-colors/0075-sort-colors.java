class Solution {
    public void sortColors(int[] nums) {
        // Arrays.sort(nums);
//         int left = 0;
//         for(int i = 1; i < nums.length; i++) {
//             int cur = nums[i];
//             System.out.println(" >> i : " + i + " , cur : " + cur);
//              System.out.println(" >> left : " + left + " , nums[left]  : " + nums[left]);
//            if (nums[left] > cur) {
//                int tmp = nums[left];
//                nums[left] = cur;
//                nums[i] = tmp;
//                left++;
//            }
//             System.out.println(Arrays.toString(nums));

//         }
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid]
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                // Swap nums[mid] and nums[high]
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
