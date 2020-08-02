package swea.d5;

import java.util.Scanner;

/*
 * 6782. 현주가 좋아하는 제곱근 놀이 
 */
public class swea6782 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			long N = sc.nextLong();		
			long result = 0;
			
			while(true) {
				if(N==2) {
					break;
				}
				long sqrtN=((long)Math.sqrt(N));
				if(sqrtN*sqrtN==N) {
					N=sqrtN;
					result++;
				}else {
					long temp=(sqrtN+1)*(sqrtN+1);
					result+=(temp-N);
					N=temp;
				}
			}			
			System.out.printf("#%d %d\n",t,result);
		}
	}
	
}
