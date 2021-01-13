package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek7453 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] nums = new int[N][4];
		
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<4;j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
		
		
		int ans = 0;
		
		int[] AB = new int[N*N];
		int[] CD = new int[N*N];
		for(int i =0;i<N;i++) {		
			for(int j =0;j<N;j++) {
				AB[i*N+j] = nums[i][0] + nums[j][1];
				CD[i*N+j] = nums[i][2] + nums[j][3];
			}
		}
		
		Arrays.sort(AB);
		Arrays.sort(CD);
		int left = 0, right = N*N-1;
		int answer = 0;
		while(left<= right) {
			long sum = AB[left] + CD[right];
			if(sum>0) {
				right--;				
			}else if(sum<0) {
				left++;
			}else if(sum==0) {
				answer++;
			}
		}
		System.out.println(answer);

	}
}
