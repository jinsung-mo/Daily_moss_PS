import java.util.*;
import java.io.*;

class Edge{
	int start, end, time;
	
	Edge(int start, int end, int time){
		this.start = start;
		this.end = end;
		this.time = time;
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int v, m, w;
	static List<Edge> edges;
	static int[] dist;
	static final int INF = 10000000;

	public static void main(String[] args) throws Exception{
		process();
	}
	
	private static void process() throws Exception{
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			edges = new ArrayList<>();
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
			
				edges.add(new Edge(s, e, t));
				edges.add(new Edge(e, s, t));
			}
			
			for(int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				edges.add(new Edge(s, e, -t));
			}
			
			if(bellmanFord()) {
				sb.append("YES").append("\n");
			}
			
			else {
				sb.append("NO").append("\n");
			}
		}
		
		
		System.out.println(sb);
	}
	
	private static boolean bellmanFord() {
		dist = new int[v + 1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		
		for(int i = 1; i <= v; i++) {
			boolean isUpdate = false;
			
			for(Edge edge: edges) {
				if(dist[edge.end] > dist[edge.start] + edge.time) {
					dist[edge.end] = dist[edge.start]+ edge.time;
					isUpdate = true;
					
					if(i == v) return true;
				}
			}
			
			if(!isUpdate) break;
		}
		
		return false;
	}
}