import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception{
		process();
	}
	
	private static void process() throws Exception{
        int a, b;
        while(true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            if(a == 0 && b == 0) break;
            
            solve(a, b);
        }
		
		System.out.println(sb);
	}
	
	private static void solve(int a, int b) {
		sb.append(a + b).append("\n");
	}
}