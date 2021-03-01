package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 가장 긴 증가하는 부분 수열 5
 * https://www.acmicpc.net/problem/14003
 */
public class baek14003 {
	static class Pair {
	    int idx;
	    int value;
	 
	    Pair(int idx, int value) {
	        this.idx = idx;
	        this.value = value;
	    }
	}
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N];
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N];
	 
	    Pair[] tracking = new Pair[N];
	 
	   
	    dp[0] = arr[0];
	    tracking[0] = new Pair(0, arr[0]);
	    int idx = 0;
	    for (int i = 1; i < N; i++) {
	        if (dp[idx] < arr[i]) {
	            dp[++idx] = arr[i];
	            tracking[i] = new Pair(idx, arr[i]);
	        } else {
	            int ii = lower_bound(idx, arr[i]);
	            dp[ii] = arr[i];
	 
	            tracking[i] = new Pair(ii, arr[i]);
	        }
	    }
	 
	    Stack<Integer> stack = new Stack<Integer>();
	    int temp = idx;
	    for (int i = N - 1; i >= 0; i--) {
	        if (temp == tracking[i].idx) {
	            stack.push(tracking[i].value);
	            --temp;
	        }
	    }
	    System.out.println(stack.size());
	    while(!stack.isEmpty()) {
	        System.out.print(stack.pop() + " ");
	    }
	}

	static int lower_bound(int end, int n) {
		int start =0;
		while(start <end) {
			int mid = (start+end)/2;
			if(dp[mid] >=n) {
				end = mid;
			}else {
				start = mid +1;
			}
		}
		return end;
	}

}

