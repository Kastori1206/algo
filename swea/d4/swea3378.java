package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea3378 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
	        sb.append("#").append(t); 
	       
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int[][] master = new int[p][7]; // ( ) { } [ ] .
			int[][] user = new int[q][7];
			
			for(int i=0;i<p;i++) {	
				if(i!=0) {
					for(int j=0;j<6;j++) {
						master[i][j] = master[i-1][j];
					}
				}
				String s = br.readLine();
				 
                int index = 0;
                while (s.charAt(index) == '.') {
                    index++;
                }
 
                master[i][6] = index;
 
                for (int j = index; j < s.length(); j++) {
                    char temp = s.charAt(j);
                    if (temp != '.') {
                        if (temp == '(') {
                        	master[i][0]++;
                        } else if (temp == ')') {
                        	master[i][1]++;
                        } else if (temp == '{') {
                        	master[i][2]++;
                        } else if (temp == '}') {
                        	master[i][3]++;
                        } else if (temp == '[') {
                        	master[i][4]++;
                        } else if (temp == ']') {
                        	master[i][5]++;
                        }
                    }
                }
			}
			for(int i=0;i<q;i++) {
				String s = br.readLine();				 
				if(i!=0) {
					for(int j=0;j<6;j++) {
						user[i][j] = user[i-1][j];
					}
				}
				
                for (int j = 0; j < s.length(); j++) {
                    char temp = s.charAt(j);
                    if (temp != '.') {
                        if (temp == '(') {
                        	user[i][0]++;
                        } else if (temp == ')') {
                        	user[i][1]++;
                        } else if (temp == '{') {
                        	user[i][2]++;
                        } else if (temp == '}') {
                        	user[i][3]++;
                        } else if (temp == '[') {
                        	user[i][4]++;
                        } else if (temp == ']') {
                        	user[i][5]++;
                        }
                    }
                }	
			}
            for (int i = 1; i < q; i++) {
                user[i][6] = 81;
            }
            
            for(int r =1 ;r<=20;r++) {
            	for(int c = 1; c<=20;c++) {
            		for(int s=1;s<=20;s++) {
            			if(check(r,c,s,master)) {              				
            				calc(r,c,s,user);
            			}
            		}
            	}
            }
            for (int i = 0; i < q; i++) {
                sb.append(" ").append(user[i][6]);
            }
 
            sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void calc(int r, int c, int s, int[][] user) {
        for (int i = 1; i < user.length; i++) {
            int x = r * (user[i - 1][0] - user[i - 1][1]) + c * (user[i - 1][2] - user[i - 1][3]) + s * (user[i - 1][4] - user[i - 1][5]);
            
            if (user[i][6] == 81) {
            	user[i][6] = x;
            } 
            else if(user[i][6] !=x) {
            	user[i][6] = -1;
            } 
        }
    }
	
    public static boolean check(int r, int c, int s, int[][] master) {
        for (int i = 0; i < master.length-1; i++) {
            if (master[i+1][6] != r * (master[i][0] - master[i][1]) + c * (master[i][2] - master[i][3]) + s * (master[i][4] - master[i][5])) {
                return false;
            }
        }
        return true;
    }
	
}
