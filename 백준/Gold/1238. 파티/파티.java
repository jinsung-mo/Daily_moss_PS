import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n, m, x;
	static Map<Integer, ArrayList<Node>> road;
	static PriorityQueue<Node> pq;
	static int[] dist;
	static int[] minNtoXdist;
	static int[] minXtoNdist;
	
	static final int INF = Integer.MAX_VALUE;
	
	static class Node{
		int to;
		int cost;
		
		Node(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws Exception{
		process();
	}
	
	private static void process() throws Exception{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		road = new HashMap<>();
		for(int i = 1; i <= n; i++) {
			road.put(i, new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			road.get(from).add(new Node(to, cost));
		}
		
		solve();
		
		System.out.println(sb);
	}
	
	private static void solve() {
		//dist가 자기자신(X)일 때는 어떻게 처리할지 생각 
		pq = new PriorityQueue<>((a, b) -> { 
			return Integer.compare(a.cost, b.cost);
		});
		
		minNtoXdist = new int[n + 1];
		minXtoNdist = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			dist = new int[n + 1];
			Arrays.fill(dist, INF);
			
			pq.offer(new Node(i, 0));
			dist[i] = 0;
			dijkstra();
			minNtoXdist[i] = dist[x];
		}
		
		dist = new int[n + 1];
		Arrays.fill(dist, INF);
		
		pq.offer(new Node(x, 0));
		dist[x] = 0;
		dijkstra();
		for(int i = 1; i <= n; i++) {
			minXtoNdist[i] = dist[i];
		}
		
		int maxTime = 0;
		for(int i = 1; i <= n; i++) {
			if(i == x) continue;
			
			maxTime = Math.max(maxTime, minNtoXdist[i] + minXtoNdist[i]);
		}
		
		sb.append(maxTime);   
	}
	
	private static void dijkstra() {	
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int to = curr.to;
			int cost = curr.cost;
			
			if(cost > dist[to]) continue;
			
			for(Node next: road.get(to)) {
				int newCost = cost + next.cost;
				if(newCost < dist[next.to]) {
					dist[next.to] = newCost; 
					pq.offer(new Node(next.to, newCost));
				}
			}
		}
	}
}