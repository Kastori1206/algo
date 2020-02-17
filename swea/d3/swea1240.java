package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;



/*
 * [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드 
 */
public class swea1240 {
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1 ;t<=T;t++) {			
			HashMap<String, Integer> maps = new HashMap<>();
			maps.put("0001101", 0);
			maps.put("0011001", 1);
			maps.put("0010011", 2);
			maps.put("0111101", 3);
			maps.put("0100011", 4);
			maps.put("0110001", 5);
			maps.put("0101111", 6);
			maps.put("0111011", 7);
			maps.put("0110111", 8);
			maps.put("0001011", 9);
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int end = 0;
			
			String[] map = new String[N];
			for(int i =0;i<N;i++) {
				map[i] = br.readLine();				
				
			}			
			String temp = null;
			boolean flag = false;
			for(int i =0;i<N;i++) {
				if(map[i].contains("1")) {
					temp = map[i];					
					for(int j=0;j<M;j++) {
						if(map[i].charAt(j)=='1') {
							flag = true;
							end = j;
						}
					}	
				}
				if(flag) {
					break;
				}				
			}
			int start = end-7*8;
			int answer = 0;
			int[] result = new int[8+1]; 
			
			for(int i =0;i<8;i++) {				
				result[i+1] = maps.get(temp.substring(7*i+start+1, 7*i+start+7+1 )); 
			}
			int sum1 =0;//홀수
			int sum2 =0;//짝수
			for(int i =1;i<8;i++) {
				if(i%2==1) {
					sum1 += result[i];
				}else {
					sum2 += result[i];
				}
			}
			if(((sum1*3)+sum2 +result[8])%10 ==0) {
				answer = sum1+sum2+result[8];
			}
			System.out.println(String.format("#%d %d",t,answer));
		}//test_case
	}//main
}
