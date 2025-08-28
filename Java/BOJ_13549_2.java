import java.io.*;
import java.util.*;

public class BOJ_13549_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        boolean[] visited = new boolean[100001];

        pq.add(new int[] { N, 0 });
        
        while (!pq.isEmpty()) {
        	int[] now = pq.poll();
        	int location = now[0], time = now[1];
        	
        	if (visited[location]) continue;
        	visited[location] = true;
        	
        	if (location == K) {
        		System.out.println(time);
        		return;
        	}

			// 1. 2*X로 순간이동
			if ((2 * location <= 100000) && (2 * location >= 0) && !visited[2 * location]) {
				pq.add(new int[] { 2 * location, time});
			}
			
			// 2. X+1로 걸어서 이동
			if ((location + 1 <= 100000) && !visited[location + 1]) {
				pq.add(new int[] { location + 1, time + 1});
			}
			
			// 3. X-1로 걸어서 이동
			if ((location - 1 >= 0) && !visited[location - 1]) {
				pq.add(new int[] { location - 1, time + 1});
			}
        }
	}
}