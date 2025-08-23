import java.io.*;
import java.util.*;

public class BOJ_16234 {
    static int N, L, R;
    static int[][] country;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		country = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				country[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int days = 0;
		while (true) {
			visited = new boolean[N][N];
			boolean moved = false;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!visited[r][c]) {
						List<int[]> union = BFS(r, c);
						if (union.size() > 1) {
							moved = true;
							calPopulation(union);
						}
					}
				}
			}
			
			if (!moved) break;
			days++;
		}
		System.out.println(days);
	}
	
	static List<int[]> BFS(int r, int c) {
        List<int[]> union = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        union.add(new int[]{r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;
                int diff = Math.abs(country[cr][cc] - country[nr][nc]);
                if (diff >= L && diff <= R) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                    union.add(new int[]{nr, nc});
                }
            }
        }

        return union;
	}
	
    static void calPopulation(List<int[]> union) {
        int total = 0;
        for (int[] cell : union) {
            total += country[cell[0]][cell[1]];
        }
        int avg = total / union.size();
        for (int[] cell : union) {
            country[cell[0]][cell[1]] = avg;
        }
    }
}
