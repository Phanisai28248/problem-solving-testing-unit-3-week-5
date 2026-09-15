class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Decides whether to add the current element to the existing subarray or start a new subarray
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Keeps track of the maximum sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}