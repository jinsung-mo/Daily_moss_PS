import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m;
	static int[][] map;
	static Queue<int[]> q;
	static boolean[][][] visited;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		process();
	}
	
	private static void process() throws Exception{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			String line = br.readLine();
			
			for(int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		solve();
		
		System.out.println(sb);
	}
	
	private static void solve() {
		q = new ArrayDeque<>();
		visited = new boolean[n][m][2];
		
		q.add(new int[] {0, 0, 1, 1}); //y, x, 벽부수기 잔액
		visited[0][0][1] = true;
		
		int result = bfs();

		sb.append(result);
	}
	
	private static int bfs() {
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int y = curr[0];
			int x = curr[1];
			int blockCnt = curr[2];
			int currCnt = curr[3];
			
			if(y == n - 1 && x == m - 1) {
				return currCnt;
			}
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(isRange(ny, nx) && map[ny][nx] == 0 && !visited[ny][nx][blockCnt]) {
					visited[ny][nx][blockCnt] = true;
					q.add(new int[] {ny, nx, blockCnt, currCnt + 1});
				}
				
				if(isRange(ny, nx) && map[ny][nx] == 1 && blockCnt == 1 && !visited[ny][nx][0]) {
					visited[ny][nx][0] = true;
					q.add(new int[] {ny, nx, 0, currCnt + 1});
				}
			}
		}
		
		return -1;
	}
	
	private static boolean isRange(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}
}