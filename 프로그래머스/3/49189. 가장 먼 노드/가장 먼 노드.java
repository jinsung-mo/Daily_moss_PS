import java.util.*;

class Solution {
    Map<Integer, ArrayList<Integer>> graph;
    Queue<int[]> q = new ArrayDeque<>();
    boolean[] visited;
    int maxLen;
    Map<Integer, Integer> depthCnt = new HashMap<>();
    
    public int solution(int n, int[][] edge) {
        graph = new HashMap<>();
        for(int i = 1; i <= n; i++){ graph.put(i, new ArrayList<>()); }
        
        for(int i = 0; i < edge.length; i++){
            int from = edge[i][0];
            int to = edge[i][1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        
        q.offer(new int[] {1, 0});
        visited = new boolean[n + 1];
        visited[1] = true;
        maxLen = 0;
        
        bfs();
        
        int result = depthCnt.get(maxLen);
        
        return result;
    }
    
    private void bfs(){
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currNode = curr[0];
            int depth = curr[1];
            
            maxLen = Math.max(maxLen, depth);
            depthCnt.put(depth, depthCnt.getOrDefault(depth, 0) + 1);
            
            for(int next: graph.get(currNode)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next, depth + 1});
                }
            }
        }
    }
}