import java.io.*;
import java.util.*;

public class BOJ_16928 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 사다리의 수
		int M = Integer.parseInt(st.nextToken());	// 뱀의 수
		int[] board = new int[101];
		boolean[] visited = new boolean[101];
		
		// 사다리 정보 입력 (N줄)
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());		
			int x = Integer.parseInt(st.nextToken());	// 출발
			int y = Integer.parseInt(st.nextToken());	// 도착
			board[x] = y;
		}
		
		// 뱀 정보 입력 (M줄)
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());		
			int u = Integer.parseInt(st.nextToken());	// 출발
			int v = Integer.parseInt(st.nextToken());	// 도착
			board[u] = v;
		}
		
		// BFS 탐색
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {1, 0});
		visited[1] = true;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int position = now[0];
			int cnt = now[1];
			
			if (position == 100) {
				System.out.println(cnt);
				return;
			}
			
			for (int i = 1; i <= 6; i++) {
				int next = position + i;
				if (next > 100) continue;
				if (board[next] != 0) next = board[next];
				if (!visited[next]) {
					visited[next] = true;
					q.offer(new int[] {next, cnt + 1});
				}
			}
		}
	}
}
