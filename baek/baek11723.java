package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek11723 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		
		int s =0;
		StringBuffer sb = new StringBuffer();
		while(M-- > 0) {
			st= new StringTokenizer(br.readLine());
			String command = st.nextToken();		
			int N;

			if(command.equals("add")) {
				N = Integer.parseInt(st.nextToken());
				s = (s | (1<<(N-1)));
			}
			else if(command.equals("remove")) {
				N = Integer.parseInt(st.nextToken());
				s = (s & ~(1<<(N-1)));
			}
			else if(command.equals("check")) {
				N = Integer.parseInt(st.nextToken());
				if((s & (1<<(N-1)))==1) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
			}
			else if(command.equals("toggle")) {
				N = Integer.parseInt(st.nextToken());
				s = (s^ (1<<(N-1)));
			}
			else if(command.equals("all")) {
				s = (1 << 20) - 1;
			}
			else if(command.equals("empty")) {
				s = 0;
			}
		}
		System.out.println(sb);
	}
}
