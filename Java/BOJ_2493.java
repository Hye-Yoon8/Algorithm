import java.io.*;
import java.util.*;

public class BOJ_2493 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] heights = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<int[]> stack = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			while (!stack.isEmpty() && stack.peekLast()[1] < heights[i]) {
				stack.removeLast();
			}
			
			if (stack.isEmpty()) sb.append("0 ");
			else sb.append(stack.peekLast()[0]).append(" ");
			
			stack.addLast(new int[] {i, heights[i]});
		}
		
		System.out.println(sb);
	}
}
