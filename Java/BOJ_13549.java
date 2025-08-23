import java.io.*;
import java.util.*;

public class BOJ_13549 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {N, 0});
        visited[N] = true;
        
        while(!dq.isEmpty()) {
        	int[] tmp = dq.poll();
        	int now = tmp[0], time = tmp[1];
        	
        	if (now == K) {
        		System.out.println(time);
        		return;
        	}
        	
            // 순간이동 (0초) -> 앞에 넣기
            if (now * 2 <= 100000 && !visited[now * 2]) {
                dq.addFirst(new int[] {now * 2, time});
                visited[now * 2] = true;
            }
            
            // 뒤로 한 칸 (1초)
            if (now - 1 >= 0 && !visited[now - 1]) {
                dq.addLast(new int[] {now - 1, time + 1});
                visited[now - 1] = true;
            }
            
            // 앞으로 한 칸 (1초)
            if (now + 1 <= 100000 && !visited[now + 1]) {
                dq.addLast(new int[] {now + 1, time + 1});
                visited[now + 1] = true;
            }
        }
	}
}