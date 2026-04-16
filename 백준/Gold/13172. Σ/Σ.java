import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static long m;
	static long n, s;
	static final int MOD = 1000000007;
	static long invN;
	static long total = 0;

	public static void main(String[] args) throws Exception{
		process();
	}
	
	private static void process() throws Exception{
		m = Integer.parseInt(br.readLine());

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			n = Long.parseLong(st.nextToken());
			s = Long.parseLong(st.nextToken());
			
			solve();
		}
        sb.append(total);
		
		System.out.println(sb);
	}
	
	private static void solve() {
		invN = recursivePower(n, MOD - 2);
		
		long curr = s * invN % MOD;
		total = (total + curr) % MOD;
	}
	
	private static long recursivePower(long base, long exp) {
		if(exp == 1) return base % MOD;
		
		long half = recursivePower(base, exp / 2);
		
		long temp = (half * half) % MOD;
		
		if(exp % 2 == 1) {
			return (temp * base) % MOD;
		}
		
		else {
			return temp;
		}
	}
}