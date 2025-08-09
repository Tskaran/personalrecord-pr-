class Solution {
    public int findKthPositive(int[] arr, int k) {
        int expected=1;
        for(int num:arr){
            if(num>expected){
                int gap = num-expected;
                if(k<=gap){
                    return expected + k-1;
                }
                k-=gap;
            }
            expected=num+1;
        }
        return expected + k - 1;
        
    }
}