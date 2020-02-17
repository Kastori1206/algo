package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1244.[S/W 문제해결 응용] 2일차 - 최대 상금
 */
public class swea1244 {
	static int answer;
	static char[] arr;
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 1;t<=T;t++) {
			answer =0;
			st = new StringTokenizer(br.readLine());
			String num = st.nextToken();
			
			arr = num.toCharArray();			
			
			N = Integer.parseInt(st.nextToken());		
			
			go(0,0);
			System.out.println(String.format("#%d %d", t, answer));
		}//test_case
	}//main
	static void go(int index,int cnt) {
		
		if(cnt == N) {
			answer = Math.max(answer,stoi(arr));
			
			return;
		}
		for(int i =index;i<arr.length;i++) {
			for(int j =i+1;j<arr.length;j++) {
				if(arr[i]-'0'<= arr[j]-'0') {
					swap(i,j);
					go(i,cnt+1);
					swap(i,j);
				}
			}
		}				
	}
	
	static int stoi(char[] nums) {
		int temp =0;		
		for(int i=0;i<nums.length;i++) {
			temp += (nums[i]-'0')*(int)(Math.pow(10, nums.length-1-i));
		}		
		return temp;
	}
	
	static void swap(int a, int b) {
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
