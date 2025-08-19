import java.io.*;
import java.util.*;

public class BOJ_2668 {
	
	static int[] arr;
	static boolean[] visited;
	static boolean[] finished;
	static List<Integer> answer = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
		arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        visited  = new boolean[N + 1];
        finished = new boolean[N + 1];
        
        for (int i = 1; i <= N; i++) if (!visited[i]) DFS(i);
		
        Collections.sort(answer);
        
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append('\n');
        for (int x : answer) sb.append(x).append('\n');
        System.out.print(sb);
	}
	
	private static void DFS(int num) {
		visited[num] = true;
		int next = arr[num];
		
		if (!visited[next]) DFS(next);
		else if (!finished[next]) {
			for (int i = next; ; i = arr[i]) {
				answer.add(i);
				if (i == num) break;
			}
		}
		
		finished[num] = true;
	}

}
