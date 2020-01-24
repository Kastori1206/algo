package swea.d2;

import java.util.Scanner;

public class swea2007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++){
            String s = sc.next();
   
            int result =0;
            for(int i =1;i<s.length()-1;i++) {            
            	if(s.substring(0,i).equals(s.substring(i,i+i))) {            	
            		result = i;
            		break;
            	}
            }
            System.out.println("#"+test_case+ " "+result);
		}
	}
}
