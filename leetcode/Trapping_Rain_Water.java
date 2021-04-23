package leetcode;

public class Trapping_Rain_Water {
	public static void main(String[] args) {
		System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
	}

	public static int trap(int[] height) {
		int answer = 0;
		int len = height.length;
		if (height == null || len <= 2) {
			return 0;
		}
		int[] left = new int[len];
		int[] right = new int[len];
		int max = height[0];

		left[0] = max;
		for (int i = 1; i < len; i++) {
			if (max < height[i]) {
				max = height[i];
				left[i] = max;
			} else {
				left[i] = max;
			}
		}
		max = height[len - 1];
		right[len - 1] = height[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			if (max < height[i]) {
				max = height[i];
				right[i] = max;
			} else {
				right[i] = max;
			}
			answer += Math.min(left[i], right[i]) - height[i];
		}
		return answer;
	}
}
