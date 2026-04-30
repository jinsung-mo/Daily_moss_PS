import java.util.*;

class Solution {
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        int n = board.length;
        int m = board.length;
        
        return bfs(n, m, board);
    }
    
    private int bfs(int n, int m, int[][] board){
        Queue<int[]> q = new ArrayDeque<>();
        int[][][] visited = new int[n][m][4];
        int minCost = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
        
        if(board[0][1] == 0){
            visited[0][1][3] = 100;
            q.offer(new int[]{0, 1, 3, 100});
        }
        
        if(board[1][0] == 0){
            visited[1][0][1] = 100;
            q.offer(new int[]{1, 0, 1, 100});
        }
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            int direc = curr[2];
            int currCost = curr[3];
            
            if((y == n - 1 && x == m - 1)){
                minCost = Math.min(minCost, currCost);
                continue;
            }
            
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(isRange(ny, nx, n, m) && board[ny][nx] != 1){
                    int nextCost = currCost + 100;
                    if(direc != i) nextCost += 500;
                    
                    if(nextCost <= visited[ny][nx][i]){
                        visited[ny][nx][i] = nextCost;
                        q.offer(new int[]{ny, nx, i, nextCost});
                    }
                }
            }
        }
        
        return minCost;
    }
    
    private boolean isRange(int y, int x, int n, int m){
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}