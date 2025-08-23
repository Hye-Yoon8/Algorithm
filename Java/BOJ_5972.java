import java.io.*;
import java.util.*;

public class BOJ_5972 {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());   // 헛간의 개수 N
      int M = Integer.parseInt(st.nextToken());   // 소들의 길의 개수 M
      
      List<List<int[]>> barn = new ArrayList<>();
      for (int i = 0; i <= N; i++) {
    	  barn.add(new ArrayList<>());
      }
      
      for (int i = 0; i < M; i++) {
         st = new StringTokenizer(br.readLine());
         int A = Integer.parseInt(st.nextToken());   // 헛간 B와 인접한 헛간 A
         int B = Integer.parseInt(st.nextToken());   // 헛간 A와 인접한 헛간 B
         int C = Integer.parseInt(st.nextToken());   // 헛간 A와 B 사이에 있는 C마리의 소
         
         barn.get(A).add(new int[] {B, C});
         barn.get(B).add(new int[] {A, C});
      }
      
      int[] cost = new int[N+1];
      Arrays.fill(cost, Integer.MAX_VALUE);
      cost[1] = 0;
      
      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
      pq.add(new int[] {1, 0});   // [현재 헛간의 위치, 준 여물의 수]
      
      while (!pq.isEmpty()) {
         int[] tmp = pq.poll();
         int now = tmp[0], stover = tmp[1];
         
         if (cost[now] < stover) continue;
         
         for (int[] next : barn.get(now)) {
        	 int nextBarn = next[0];
        	 int nextCost = stover + next[1];
        	 
        	 if (cost[nextBarn] > nextCost) {
        		 cost[nextBarn] = nextCost;
        		 pq.add(new int[] {nextBarn, nextCost});
        	 }
         }
      }
      
      System.out.println(cost[N]);
   }
}
