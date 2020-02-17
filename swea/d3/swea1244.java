package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1244.[S/W 문제해결 응용] 2일차 - 최대 상금
 */
public class swea1244 {
	static int max;
	static int[]result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			String num = st.nextToken();
			int[] arr = new int[num.length()];
			for(int i =0;i<num.length();i++) {
				arr[i] = num.charAt(i)-'0';
			}
			int r = Integer.parseInt(st.nextToken());
			result = new int[r];
			
		}//test_case
	}//main
	static void go(int[]arr,boolean[] v,int index,int r,int n) {
		if(index ==r) {
			return;
		}
		for(int i =0;i<n;i++) {
			if(v[i]) {
				continue;
			}
			v[i] = false;
			result[index] = arr[i];
		}
				
	}
}
