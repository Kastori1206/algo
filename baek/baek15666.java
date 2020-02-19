package baek;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 	15664.N과 M(12)
 * https://www.acmicpc.net/problem/15666
 * 
 */
public class baek15666 {	
	static List<Integer> list;
	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		list = new ArrayList<>();
		
		result = new int[N];
		for(int i =0;i<N;i++) {
			int num = sc.nextInt();
			if(!list.contains(num)) {
				list.add(num);
			}
			
		}
		Collections.sort(list);
		System.out.println(dfs(0,0,M));
	}
	static StringBuffer dfs(int index,int start, int m) {
		if(index == m) {
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<m;i++) {
				sb.append(result[i]);				
				if(i!=m) {
					sb.append(' ');
				}
			}
			sb.append("\n");			
			return sb;
		}
		StringBuffer ans = new StringBuffer();
		for(int i =start;i<list.size();i++) {
			result[index] = list.get(i);
			ans.append(dfs(index+1,i,m));			
		}
		return ans;
	}	
}
