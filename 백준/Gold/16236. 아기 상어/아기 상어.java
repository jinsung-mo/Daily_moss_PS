import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0}; 
    static int[] dx = {0, 0, -1, 1};
    
    static int sharkY, sharkX;
    static int sharkSize = 2;
    static int eaten = 0;
    static int time = 0;

    static class Node implements Comparable<Node> {
        int y, x, dist;

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if (this.dist != o.dist) return Integer.compare(this.dist, o.dist); 
            if (this.y != o.y) return Integer.compare(this.y, o.y);             
            return Integer.compare(this.x, o.x);                                
        }
    }

    public static void main(String[] args) throws Exception {
        process();
    }
    
    private static void process() throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) { 
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkY = i; 
                    sharkX = j; 
                    map[i][j] = 0;
                }
            }
        }

        solve();
        System.out.println(time);
    }
    
    private static void solve() {
        while (true) {
            Node target = bfs();
            if (target == null) break;

            time += target.dist;
            sharkY = target.y;
            sharkX = target.x;
            
            map[sharkY][sharkX] = 0;
            eaten++;

            if (eaten == sharkSize) {
                sharkSize++;
                eaten = 0;
            }
        }
    }

    private static Node bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];

        pq.add(new Node(sharkY, sharkX, 0));
        visited[sharkY][sharkX] = true;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (map[curr.y][curr.x] != 0 && map[curr.y][curr.x] < sharkSize) {
                return curr;
            }

            for (int i = 0; i < 4; i++) {
                int ny = curr.y + dy[i]; 
                int nx = curr.x + dx[i]; 

                if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
                    if (map[ny][nx] <= sharkSize) {
                        visited[ny][nx] = true;
                        pq.add(new Node(ny, nx, curr.dist + 1));
                    }
                }
            }
        }
        
        return null;
    }
}