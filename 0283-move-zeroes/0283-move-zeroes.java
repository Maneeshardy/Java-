class Solution {
    public void moveZeroes(int[] nums) {
        int prev = 0;
        int len = nums.length;

        for(int i = 0;i < len; i++){
            if(nums[i] != 0){
                if(i != prev){
                    int temp = nums[i];
                    nums[i] = nums[prev];
                    nums[prev] = temp;
                }
                prev++;
            }
        }
        
    }
}