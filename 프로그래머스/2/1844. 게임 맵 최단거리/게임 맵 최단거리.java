import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int result = bfs(maps);
        
        return result;
    }
    
    public int bfs(int[][] maps){
        int[] dx = {0, 0, -1 , 1};
        int[] dy = {-1, 1, 0, 0};
        
        int endY = maps.length;
        int endX = maps[0].length;
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[endY][endX];
        
        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            int currCnt = curr[2];
            
            if(y == endY - 1 && x == endX - 1) return currCnt;
            
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(isRange(endY, endX, ny, nx)){
                    if(!visited[ny][nx] && maps[ny][nx] == 1){
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny, nx, currCnt + 1});
                    }
                }
            }
        }
        
        return -1;
    }
    
    public boolean isRange(int endY, int endX, int y, int x){
        return y >= 0 && y < endY && x >= 0 && x < endX;
    }
}