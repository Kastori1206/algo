package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * A->B
 * https://www.acmicpc.net/problem/16953
 */
public class baek16953 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		int answer = 1;
		while (B != A) {
			if (B < A) {
				answer = -1;
				break;
			}

			String num = String.valueOf(B);

			if (num.charAt(num.length() - 1) != '1' && B % 2 != 0) {
				answer = -1;
				break;
			}

			if (B % 2 == 0) {
				B /= 2;
			} else {
				num = num.substring(0, num.length() - 1);
				B = Long.parseLong(num);
			}
			answer++;
		}

		bw.write(answer + "\n");
		br.close();
		bw.close();

	}
}
