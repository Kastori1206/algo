package leetcode;

/*
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
		System.out.println(lengthOfLIS(new int[] {0,1,0,3,2,3}));
		System.out.println(lengthOfLIS(new int[] {7,7,7,7,7,7,7}));
		
	}
	static int[] lis;
	public static int lengthOfLIS(int[] nums) {
		
		int len = nums.length;
		if(len == 1) {
			return 1;
		}
		lis = new int[nums.length];
		
		lis[0] = nums[0];
		int i = 1;
		int j = 0;
		while(i<len) {
			if(lis[j] < nums[i]) {
				lis[j+1] = nums[i];
				j++;
			}else {
				int idx = binarysearch(0, j, nums[i]);
				lis[idx] = nums[i];
			}
			i++;
		}
		
		return j+1;
	}
	public static int binarysearch(int left, int right, int target) {
		int mid;
		
		while(left<right) {
			mid = (left+right)/2;
			
			if(lis[mid] < target) {
				left = mid +1;
			}else {
				right = mid;
			}			
		}
		return right;
	}
}
