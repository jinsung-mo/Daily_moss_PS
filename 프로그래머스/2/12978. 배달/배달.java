import java.util.*;

class Node{
    int to;
    int cost;
    
    public Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
}

class Solution {
    static final int INF = Integer.MAX_VALUE;
    
    public int solution(int N, int[][] road, int K) {
        Map<Integer, ArrayList<Node>> graph = new HashMap<>();
        for(int i = 1; i <= N; i++){
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] r: road){
            int go = r[0];
            int end = r[1];
            int cost = r[2];
            
            graph.get(go).add(new Node(end, cost));
            graph.get(end).add(new Node(go, cost));
        }
        
        return dijkstra(N, graph, K);
    }
    
    public int dijkstra(int N, Map<Integer, ArrayList<Node>> graph, int K){
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.cost, b.cost);
        });
        pq.offer(new Node(1, 0));
        
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            
            //이미 더 최단 경로로 업데이트 돼 있다면 패스
            if(dist[curr.to] < curr.cost)
                continue;
            
            for(Node next: graph.get(curr.to)){
                if(dist[next.to] > dist[curr.to] + next.cost){
                    dist[next.to] = dist[curr.to] + next.cost;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
        
        int deliverCnt = 0;
        for(int di: dist){
            if(di <= K){
                deliverCnt++;
            }
        }
        
        return deliverCnt;
    }
}