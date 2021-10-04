package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class baek11444 {
	static final int MOD = 1000000007;
	static Map<Long, Long> dp = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());
		long answer = fibo(N);
		
		System.out.println(answer);
	}

	static long fibo(long n) {
		if (n == 0) {
			return 0;
		}else if (n == 1 || n == 2) {
			return 1;
		}else if (dp.containsKey(n)) {
			return dp.get(n);
		}else {
			if(n % 2 == 1) {
				long m = (n + 1) / 2;
				long t1 = fibo(m);
				long t2 = fibo(m - 1);
                

				dp.put(n, (t1 * t1 + t2 * t2) % MOD);
				return dp.get(n);
			} else {
				long m = n / 2;
				long t1 = fibo(m - 1);
				long t2 = fibo(m);
                dp.put(n, ((2 * t1 + t2) * t2) % MOD);

				return dp.get(n);
			}
		}

	}
}
