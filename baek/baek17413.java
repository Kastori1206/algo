package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 17413. 단어뒤집기
 * 
 */
public class baek17413 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		
		StringBuffer result = new StringBuffer();
		int i=0;
		while(true) {
			if(i==str.length()) {
				break;
			}
			if(str.charAt(i)==' '){
				result.append(' ');
				i++;
			}
			if(str.charAt(i)=='<') {
				while(true) {
					result.append(str.charAt(i));
					if(str.charAt(i)=='>') {
						i++;
						break;
					}
					i++;
				}
			}
			StringBuffer temp = new StringBuffer();
			while(true) {
				if(i==str.length() || str.charAt(i)==' '|| str.charAt(i)=='<') {
					result.append(temp.reverse());					
					
					break;
				}
				temp.append(str.charAt(i));
				i++;
			}
		}
		System.out.println(result);
	}
}
