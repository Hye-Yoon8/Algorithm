import java.io.*;
import java.util.*;

public class BOJ_1927 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int val = Integer.parseInt(br.readLine());
			
			if(val == 0) {
				if(pq.isEmpty()) System.out.println("0");
				else System.out.println(pq.poll());
			}
			else pq.add(val);
		}
	}
}