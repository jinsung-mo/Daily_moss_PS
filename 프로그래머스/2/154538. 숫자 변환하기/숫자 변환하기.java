import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }
    
    private int bfs(int x, int y, int n){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, 0});
        
        boolean[] used = new boolean[y + 1];
        used[x] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currNum = curr[0];
            int count = curr[1];
            
            if(currNum == y) return count;
            
            int[] nextNums = {currNum + n, currNum * 2, currNum * 3};
            
            for(int next: nextNums){
                if(next <= y && !used[next]){
                    used[next] = true;
                    q.offer(new int[]{next, count + 1});
                }
            }
        }
        
        return -1;
    }
}