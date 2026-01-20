class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int total =0;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
            while(total>=target){
                res=Math.min(res,i-left+1);
                total-=nums[left];
                left++;
            }
        }
        if(res==Integer.MAX_VALUE) return 0;
        else return res;
    }
}