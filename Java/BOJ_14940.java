import java.io.*;
import java.util.*;

public class BOJ_14940 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int rGoal = 0, cGoal = 0;	// 목표 지점의 위치
		int[][] maps = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				if (maps[i][j] == 2) {
					rGoal = i;
					cGoal = j;
				}
			}
		}
		
		int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
		int[][] dist = new int[n][m];
		for (int i = 0; i < n; i++) Arrays.fill(dist[i], -1);
		
		Deque<int[]> dq = new ArrayDeque<>();
		
		dq.add(new int[] {rGoal, cGoal});
		dist[rGoal][cGoal] = 0;
		
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			int r = now[0], c = now[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && (dist[nr][nc] == -1) && (maps[nr][nc] != 0)) {
					dist[nr][nc] = dist[r][c] + 1;
					dq.add(new int[] {nr, nc});
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (maps[i][j] == 0) sb.append(0);
				else sb.append(dist[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
