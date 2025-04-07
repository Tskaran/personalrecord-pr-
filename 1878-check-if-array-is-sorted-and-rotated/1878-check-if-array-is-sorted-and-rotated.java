class Solution {
    public boolean sorted(int[] arr){
        for(int i = 0 ; i < arr.length - 1 ; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public boolean check(int[] nums) {
        if(sorted(nums)){
                return true;
            }
        int n = nums.length - 1;
        while(n>0){
            int temp = nums[nums.length - 1];
            for(int i = nums.length - 1 ; i > 0 ; i--){
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
            if(sorted(nums)){
                return true;
            }
            n--;
        }
        return false;
    }
}