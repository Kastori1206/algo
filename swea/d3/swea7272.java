package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea7272 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for(int i=0;i<N;i++) {
			
			arr[i] = br.readLine();			
		}		
		for(int i =0;i<N;i++) {
			String[] temp = arr[i].split(" ");
			boolean flag = true;
			for(int j=0;j<temp[0].length();j++) {
				if(temp[0].length() != temp[1].length()) {
					flag = false;
					break;
				}
				if(count(temp[0].charAt(j)) != count(temp[1].charAt(j))) {
					flag = false;
					break;
				}
			}
			String result ="";
			if(flag) {
				result = "SAME";				
			}else {
				result = "DIFF";
			}
			System.out.println(String.format("#%d %s", i+1,result));
		}
		
	}
	static int count(char c) {
		if(c =='B') {
			return 2;			
		}else if(c == 'A'|| c =='D' || c=='O'||c=='P'||c=='Q'||c=='R') {
			return 1;
		}else {
			return 0;
		}			
	}
}

