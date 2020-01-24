package swea.d2;

import java.util.Scanner;

public class swea1989 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String s = sc.next();
			//StringBuffer 클래스 사용
//            String a = new StringBuffer(s).reverse().toString();
//            if(s.equals(a)) {
//            	System.out.println("#"+test_case+" "+1);
//            }else {
//            	System.out.println("#"+test_case+" "+0);
//            }
			String r="";
			for(int i =s.length()-1;i>=0;i--) {
				r+= Character.toString(s.charAt(i));				
			}
			if(s.equals(r)) {
				System.out.println("#"+test_case+" "+1);
            }else {
            	System.out.println("#"+test_case+" "+0);
            }
			
		}
	}
}
