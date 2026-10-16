class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        Queue<int[]> q = new ArrayDeque<>();

        int freshCnt = initQueueAndCntFresh(grid, q);

        if(freshCnt == 0) return 0;

        return bfs(grid, q, freshCnt);
    }

    private int initQueueAndCntFresh(int[][] grid, Queue<int[]> q){
        int y = grid.length;
        int x = grid[0].length;
        int freshCnt = 0;

        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i, j});
                else if(grid[i][j] == 1) freshCnt++;
            }
        }

        return freshCnt;
    }

    private int bfs(int[][] grid, Queue<int[]> q, int freshCnt){
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        int y = grid.length;
        int x = grid[0].length;
        int minutes = 0;

        while(!q.isEmpty()){
            int size = q.size();
            boolean rotted = false;

            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                int cy = curr[0];
                int cx = curr[1];

                for(int j = 0; j < 4; j++){
                    int ny = dy[j] + cy;
                    int nx = dx[j] + cx;

                    if(isRange(y, x, ny, nx) && grid[ny][nx] == 1){
                        grid[ny][nx] = 2;
                        q.offer(new int[]{ny, nx});
                        freshCnt--;
                        rotted = true;
                    }
                }
            }

            if(rotted) minutes++;
        }

        if(freshCnt != 0) return -1;

        return minutes;
    }

    private boolean isRange(int maxY, int maxX, int y, int x){
        return y >= 0 && y < maxY && x >= 0 && x < maxX;
    }
}







