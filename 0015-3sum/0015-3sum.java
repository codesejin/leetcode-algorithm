import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        Set<List<Integer>> list = new HashSet<>();
        int sum = 0;

            for(int i = 0; i < nums.length-1; i++){

                 int low = i + 1;
                 int high = nums.length -1;

            while(low < high){                
                sum = nums[i] + nums[low] + nums[high];
                if(sum == 0){
                    list.add(Arrays.asList(nums[i], nums[low],nums[high]));
                    low++;
                    high--;

                }
                else if(sum < 0){
                    low++;
                }
                else{
                    high--;
                }

            }
        }    
        return new ArrayList<>(list);
        
    }
}