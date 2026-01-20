class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> dis =new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(dis.contains(nums[i])) return true;
            dis.add(nums[i]);
            if(i>=k) dis.remove(nums[i-k]);
        }return false;
    }
}
