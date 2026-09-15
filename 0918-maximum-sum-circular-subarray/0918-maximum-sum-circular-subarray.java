class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        
        int currentMax = 0;
        int maxKadane = nums[0];
        
        int currentMin = 0;
        int minKadane = nums[0];
        
        for (int num : nums) {
            totalSum += num;
            
            // Standard Kadane's to find maximum subarray sum
            currentMax = Math.max(num, currentMax + num);
            maxKadane = Math.max(maxKadane, currentMax);
            
            // Modified Kadane's to find minimum subarray sum
            currentMin = Math.min(num, currentMin + num);
            minKadane = Math.min(minKadane, currentMin);
        }
        
        // If all numbers are negative, totalSum == minKadane, 
        // so return maxKadane (the maximum single negative element)
        if (maxKadane < 0) {
            return maxKadane;
        }
        
        return Math.max(maxKadane, totalSum - minKadane);
    }
}