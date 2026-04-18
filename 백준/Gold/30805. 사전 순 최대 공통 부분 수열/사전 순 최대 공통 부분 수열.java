import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n;
	static int[] a;
	static int m;
	static int[] b;
	static List<Integer> result;

	public static void main(String[] args) throws Exception{
		process();
	}
	
	private static void process() throws Exception{
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		m =Integer.parseInt(br.readLine());
		b = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		solve();
		
		System.out.println(sb);
	}
	
	private static void solve() {
		result = new ArrayList<>();
		
		greedy();
	}
	
	private static void greedy() {
		int startA = 0;
		int startB = 0;
		
		while(true) {
			int maxVal = -1;
			int nextStartA = -1;
			int nextStartB = -1;
			
			for(int val = 100; val > 0; val--) {
				int tempA = -1;
				int tempB = -1;
				
				for(int i = startA; i < n; i++) {
					if(a[i] == val) {
						tempA = i;
						break;
					}
				}
				
				for(int i = startB; i < m; i++) {
					if(b[i] == val) {
						tempB = i;
						break;
					}
				}
				
				if(tempA != -1 && tempB != -1) {
					maxVal = val;
					nextStartA = tempA;
					nextStartB = tempB;
                    break;
				}
			}
			
			if(maxVal == -1) {
				break;
			}
			
			result.add(maxVal);
			startA = nextStartA + 1;
			startB = nextStartB + 1;
		}
		
		sb.append(result.size()).append("\n");
		for(int val: result) {
			sb.append(val).append(" ");
		}
	}
}