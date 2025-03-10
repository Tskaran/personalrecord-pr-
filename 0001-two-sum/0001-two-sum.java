import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hash map to store the value and its index
        Map<Integer, Integer> numMap = new HashMap<>();
        
        // Iterate through each element in the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if the complement exists in the map
            if (numMap.containsKey(complement)) {
                // Return the indices if found
                return new int[] { numMap.get(complement), i };
            }
            
            // Add the current number and its index to the map
            numMap.put(nums[i], i);
        }
        
        // Since the problem states there's exactly one solution, this line is just a fallback
        throw new IllegalArgumentException("No two sum solution");
    }
}