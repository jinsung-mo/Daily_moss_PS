import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        boolean[] x = new boolean[n];
        boolean[] diagR = new boolean[2 * n];
        boolean[] diagL = new boolean[2 * n];

        backtrack(0, n, board, x, diagR, diagL, res);

        return res;
    }

    private void backtrack(int y, int n, char[][] board, boolean[] xs, boolean[] diagR, boolean[] diagL, List<List<String>> res){
        if(y == n){
            res.add(consBoard(board));

            return;
        }

        for(int x = 0; x < n; x++){
            int d1 = y - x + n;
            int d2 = y + x;

            if(xs[x] || diagR[d1] || diagL[d2]) continue;

            board[y][x] = 'Q';
            xs[x] = true;
            diagR[d1] = true;
            diagL[d2] = true;

            backtrack(y + 1, n , board, xs, diagR, diagL, res);

            board[y][x] = '.';
            xs[x] = false;
            diagR[d1] = false;
            diagL[d2] = false;
        }
    }

    private List<String> consBoard(char[][] board){
        List<String> ress = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            ress.add(new String(board[i]));
        }

        return ress;
    }
}