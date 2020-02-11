package baek;

import java.util.Scanner;

public class baek8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1;t<=T;t++) {
			
			String str = sc.nextLine();			
			char[] c = str.toCharArray();
			
			int score = 1;
			int result = 0;
			for(int i=0;i<c.length;i++) {
				if(c[i]=='O') {
					result+=score++;
				}else {
					score=1;					
				}
				
			}
			System.out.println(result);			
		}
	}
}
