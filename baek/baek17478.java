package baek;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 재귀함수가 먼가요?
 * https://www.acmicpc.net/problem/17478
 */
public class baek17478 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		String[] arr = new String[7];
		arr[0] = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
		arr[1] = "\"재귀함수가 뭔가요?\"";
		arr[2] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		arr[3] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		arr[4] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		arr[5] ="라고 답변하였지.";	
		arr[6] ="\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		
		go(0,arr); 
	}
	static void go(int n, String[] arr) {
		String temp ="____";
		String str ="";
		if(n==N+1) {
			return;
		}
		for(int i =0;i<n;i++) {
			str += temp;
		}
		if(n==N) {	
			System.out.println(str+arr[1]);
			System.out.println(str+arr[6]);			
		}else if(n==0){
			for(int i =0;i<arr.length-2;i++) {			
				System.out.println(str+ arr[i]);		
			}			
		}
		else {
			for(int i =1;i<arr.length-2;i++) {			
				System.out.println(str+ arr[i]);		
			}			
		}		
		go(n+1,arr);		
		System.out.println(str+arr[5]);
	
	}
}
