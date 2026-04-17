import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m, r;
	static int[] itemCnt;
	static Map<Integer, ArrayList<Node>> graph;
	static PriorityQueue<Node> pq;
	static int[] dist;
	static int maxItem;
	static final int INF = Integer.MAX_VALUE;
	
	static class Node{
		int to, cost;
		
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
		r = Integer.parseInt(st.nextToken());
		
		itemCnt = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			itemCnt[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new HashMap<>();
		for(int i = 1; i <= n; i++) {
			graph.put(i, new ArrayList<>());
		}
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(new Node(to, cost));
			graph.get(to).add(new Node(from, cost));
		}
		
		solve();
		
		System.out.println(sb);
	}
	
	private static void solve() {
		pq = new PriorityQueue<>((a, b) -> {
			return Integer.compare(a.cost, b.cost);
		});
		maxItem = 0;
		
		for(int i = 1; i <= n; i++) {
			dist = new int[n + 1];
			Arrays.fill(dist, INF);
			
			pq.offer(new Node(i, 0));
			dist[i] = 0;
			
			dijkstra();
			
			int itemCntSum = 0;
			for(int j = 1; j <= n; j++) {
				if(dist[j] <= m)
					itemCntSum += itemCnt[j];
			}
			
			maxItem = Math.max(maxItem, itemCntSum);
		}
		
		sb.append(maxItem);
	}
	
	private static void dijkstra() {
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(dist[curr.to] < curr.cost) continue;
			
			for(Node next: graph.get(curr.to)) {
				int newCost = curr.cost + next.cost;
				if(dist[next.to] > newCost) {
					dist[next.to] = newCost;
					pq.offer(new Node(next.to, newCost));
				}
			}
		}
	}
}