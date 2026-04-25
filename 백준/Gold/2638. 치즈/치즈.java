import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static Queue<Point> cheese = new ArrayDeque<>();
	static int cheeseCnt = 0;
	
	static class Point{
		int y, x;
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws Exception{
		process();
	}
	
	private static void process() throws Exception{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					cheese.add(new Point(i, j));
					cheeseCnt++;
				}
			}
		}
		
		solve();
		
		System.out.println(sb);
	}
	
	private static void solve() {
		int time = 0;
		while(cheeseCnt > 0) {
			bfs();
			melt();
			time++;
		}
		
		sb.append(time);
	}
	
	private static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		visited = new boolean[n][m];
		
		q.add(new Point(0, 0));
		visited[0][0] = true;
		map[0][0] = 2;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				if(isRange(ny, nx)) {
					if(!visited[ny][nx] && map[ny][nx] != 1) {
						visited[ny][nx] = true;
						map[ny][nx] = 2; //외부공기 == 2;
						q.offer(new Point(ny, nx));
					}
				}
			}
		}
	}
	
	private static void melt() {
		int size = cheese.size();
		List<Point> toMelt = new ArrayList<>();
		
		for(int i = 0; i < size; i++) {
			Point p = cheese.poll();
			
			int airCnt = 0;
			for(int d = 0; d < 4; d++) {
				int ny = p.y + dy[d];
				int nx = p.x + dx[d];
				
				if(map[ny][nx] == 2) airCnt++;
			}
				
			if(airCnt >= 2) {
				toMelt.add(p);
				cheeseCnt--;
			} else {
				cheese.add(p);
			}
		}
		
		for(Point p: toMelt) {
			map[p.y][p.x] = 2; 
		}
	}
	
	private static boolean isRange(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}
}