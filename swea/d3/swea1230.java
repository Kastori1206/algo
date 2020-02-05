package swea.d3;

import java.util.LinkedList;
import java.util.Scanner;

public class swea1230 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1 ;test_case<=10;test_case++) {
			int N = sc.nextInt(); //원본 암호문의 길이
			
			LinkedList<Integer> list = new LinkedList<>();
			
			for(int i =0;i<N;i++) {
				list.add(sc.nextInt());
			}
			
			int M = sc.nextInt(); //명령어의 개수
			for(int i= 0 ; i<M;i++) {
				String command = sc.next();
				switch (command) {
				case "I":
					int index = sc.nextInt();
					int size = sc.nextInt();
					for(int j = 0; j<size;j++) {
						int temp = sc.nextInt();
						list.add(index++, temp);
					}
					break;
				case "D":
					index = sc.nextInt();
					size = sc.nextInt();
					for(int j =0;j<size;j++) {
						list.remove(index);
					}
					break;
				case "A":
					size = sc.nextInt();
					for(int j=0;j<size;j++) {
						int temp =sc.nextInt();
						list.add(temp);
					}					
					break;
				}
			}
			System.out.print("#"+ test_case+" ");
			for(Integer n : list) {
				System.out.print(n +" ");
			}
			System.out.println();
		}
	}
}
