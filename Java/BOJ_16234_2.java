import java.io.*;
import java.util.*;

public class BOJ_16234_2 {
	static int N, L, R;
	static int[][] population;
	static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		population = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				population[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int days = 0;		
		while (true) {
			visited = new boolean[N][N];
			boolean isMoved = false;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						List<int[]> union = getUnion(i, j);
						if (union.size() > 1) {
							movePopulation(union);
							isMoved = true;
						}
					}
				}
			}
			
			if (!isMoved) break;
			days++;
		}
		
		System.out.println(days);
	}
	
	// 국경선 열기
	private static List<int[]> getUnion(int r, int c) {
		List<int[]> union = new ArrayList<>();
		union.add(new int[]{r, c});
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {r, c});
		
		visited[r][c] = true;
		
		while (!dq.isEmpty()) {
			int[] current = dq.poll();
			int cr = current[0], cc = current[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if (nr >= N || nr < 0 || nc >= N || nc < 0 || visited[nr][nc]) continue;
				
				int diff = Math.abs(population[cr][cc] - population[nr][nc]);
				if (diff >= L && diff <= R && !visited[nr][nc]) {
					union.add(new int[] {nr, nc});
					dq.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		
		return union;
	}
	
	// 인구 이동
	private static void movePopulation(List<int[]> union) {
		int result = 0;
		for (int[] rc : union) result += population[rc[0]][rc[1]];
		result /= union.size();
		for (int[] rc : union) population[rc[0]][rc[1]] = result;
	}
}
