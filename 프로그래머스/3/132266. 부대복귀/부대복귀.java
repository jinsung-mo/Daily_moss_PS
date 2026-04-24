import java.util.*;

class Solution {
    int[] result;
    int[] dist;
    Map<Integer, ArrayList<Integer>> area;
    Queue<int[]> q;
    final int INF = Integer.MAX_VALUE;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        result = new int[sources.length];
        dist = new int[n + 1];
        q = new ArrayDeque<>();
        area = new HashMap<>();
        
        for(int i = 1; i <= n; i++){
            area.put(i, new ArrayList<>());    
        }
        
        for(int[] road: roads){
            area.get(road[0]).add(road[1]);
            area.get(road[1]).add(road[0]);
        }

        Arrays.fill(dist, INF);
        q.offer(new int[]{destination, 0});
        dist[destination] = 0;
        dijkstra();
        
        int idx = 0;
        for(int source: sources){
            if(dist[source] == INF) result[idx++] = -1;
            else result[idx++] = dist[source];
        }
        
        return result;
    }
    
    private void dijkstra(){
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currNode = curr[0];
            int currCost = curr[1];
            
            if(dist[currNode] < currCost) continue;
            
            for(int next: area.get(currNode)){
                int newCost = currCost + 1;
                if(dist[next] > newCost){
                    dist[next] = newCost;
                    q.offer(new int[] {next, newCost});
                }
            }
        }
    }
}