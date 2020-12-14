package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek10973 {
	static int N,cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];	
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		if(nextPermutation(nums)) {
			for(int a : nums) {
				System.out.print(a+ " ");
			}
		}else {
			System.out.println(-1);
		}
	}
	private static boolean nextPermutation(int[] nums) {
		int i = nums.length-1;
		while(i>0 && nums[i-1] <= nums[i]) {
			i--;
		}
		
		if(i<=0) {
			return false;
		}
		
		int j =nums.length-1;
		while(nums[j] >=nums[i-1]) {
			j--;
		}
		
		swap(nums,i-1,j);
		
		j = nums.length-1;
		while(i<j) {
			swap(nums, i, j);
			i++;
			j--;
		}
		return true;
	}
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	
	
}
