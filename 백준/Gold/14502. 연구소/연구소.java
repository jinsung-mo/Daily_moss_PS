import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n, m;
	static int[][] map;
	static List<int[]> list;
	static Queue<int[]> q;
	static boolean[][] visited;
	static int maxSafy;
	
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
		list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2) {
					list.add(new int[] {i, j});
				}
			}
		}
		
		solve();
		
		System.out.println(sb);
	}
	  
	private static void solve() {
		maxSafy = 0;
		
		createBlock(0);
		
		sb.append(maxSafy);
	}

	private static void createBlock(int count) {
		if(count == 3) {
			bfs();
			
			int currMax = 0; 
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(!visited[i][j] && map[i][j] == 0)
						currMax++;
				}
			}
			
			maxSafy = Math.max(maxSafy, currMax);
			
			return;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					createBlock(count + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	private static void bfs() {
		q = new ArrayDeque<>();
		visited = new boolean[n][m];
		
		for(int[] virusPos: list) {
			int y = virusPos[0];
			int x = virusPos[1];
			
			q.offer(new int[] {y, x});
			visited[y][x] = true;
		}
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int y = curr[0];
			int x = curr[1];
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(isRange(ny, nx) && !visited[ny][nx] && map[ny][nx] == 0) {
					visited[ny][nx] = true;
					q.offer(new int[] {ny, nx});
				}
			}
		}
	}
	
	private static boolean isRange(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}
}