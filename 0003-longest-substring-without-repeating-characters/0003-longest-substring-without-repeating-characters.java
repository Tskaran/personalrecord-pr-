class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        Set<Character> seen =new HashSet<>();
        int maxLen=0;
        int left=0;
        for(int right=0;right<n;right++){
            while(seen.contains(s.charAt(right))){
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}