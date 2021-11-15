package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 애너그램
 * https://www.acmicpc.net/problem/6443
 */
public class baek6443 {
	static StringBuilder answer = new StringBuilder();
	static char[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			arr = br.readLine().toCharArray();
			Arrays.sort(arr);
			for (int i = 0; i < arr.length; i++) {
				answer.append(arr[i]);
			}
			answer.append("\n");

			while (next_permutation()) {
				for (int i = 0; i < arr.length; i++) {
					answer.append(arr[i]);
				}
				answer.append("\n");
			}
		}

		System.out.println(answer.toString());
	}

	public static boolean next_permutation() {
		int i = arr.length - 1;

		while (i > 0 && arr[i] <= arr[i - 1]) {
			i--;
		}

		if (i <= 0) {
			return false;
		}
		
		int j = arr.length - 1;

		while (arr[i - 1] >= arr[j]) {
			j--;
		}
		char temp = arr[j];
		arr[j] = arr[i - 1];
		arr[i - 1] = temp;

		j = arr.length - 1;
		while (i < j) {
			temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
			i++;
			j--;
		}

		return true;
	}
}
