package baek;

import java.util.Scanner;

public class baek2941 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] c = str.toCharArray();
		int cnt = 0;
		
		int size = c.length;

		for(int i=0; i<size; i++) { 
			cnt++; 
			switch(c[i]) {
			case 'c': 
				if(i < size-1 && (c[i+1]=='=' || c[i+1]=='-')) { 
					i++; 
				} 
				break;
			case 'd': 
				if(i < size-2 && c[i+1]=='z' && c[i+2]=='=') {
					i+=2; 
				}else if(i < size-1 && c[i+1]=='-') {
					i++; 
				} 
				break; 
			case 'l': 
			case 'n': 
				if(i < size-1 && c[i+1]=='j') {
					i++; 
				} 
				break; 
			case 's': 
			case 'z': 
				if(i < size-1 && c[i+1]=='=') {
					i++; 
				} 
				break; 
			} 
		}		
		System.out.println(cnt);
				
	}
}
