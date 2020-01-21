package swea.d2;

import java.util.Scanner;

public class swea1926 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String result ="";
		for(int i =1 ; i<= N; i++) {
			int num = i;
			boolean chk = false;
			
			while(num!=0) {
				int n = num % 10;
				num /=10;
				if(n!=0 && n%3==0) {
					chk = true;
					result +="-";				
				}				
			}
			if(chk) {
				result += " ";
			}else {
				result += i + " ";
			}
			
		}

		System.out.println(result);
	}

}
