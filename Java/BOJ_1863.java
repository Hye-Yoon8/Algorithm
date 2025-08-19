import java.io.*;
import java.util.*;

public class BOJ_1863 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());		
		
		Deque<Integer> stack = new ArrayDeque<>();
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			while (!stack.isEmpty() && stack.peek() > y) {
				stack.pop();
				answer++;
			}
			
			if ((stack.isEmpty() || stack.peek() < y) && y > 0) stack.push(y);
		}
		
		answer += stack.size();
		System.out.println(answer);
	}
}
