package leetcode;

public class MaximumSubarray {
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(new Solution().maxSubArray(nums));
	}

	static class Solution {
		public int maxSubArray(int[] nums) {
			int n = nums.length;
			int max  = Integer.MIN_VALUE;
			int partialSum =0;
			
			for(int i =0;i<n;i++) {
				partialSum = Math.max(0, partialSum) + nums[i];
				max = Math.max(partialSum, max);
			}
			return max;
		}

	}
}
