package codeforces.div3.round702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * C. Sum of Cubes
 * https://codeforces.com/contest/1490/problem/C
 */
public class C {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Long> set = new HashSet<>();
		
		for(long i =1;i<=10000;i++) {
			set.add(i*i*i);
		}
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T;t++) {
			long x = Long.parseLong(br.readLine());
			boolean flag = false;
		
			Iterator iter = set.iterator();
			while(iter.hasNext()) {
				long num = (long) iter.next();
				if(set.contains(x-num)) {
					flag = true;
					break;
				}
			}
			if(flag) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}
