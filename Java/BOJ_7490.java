import java.io.*;

public class BOJ_7490 {
	
	static StringBuilder sb = new StringBuilder();
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			DFS(2, 1, 1, "1");
			if (T > 0) sb.append('\n');
		}
		
		System.out.println(sb);
	}

	private static void DFS(int num, int last, int result, String tmp) {
		if (num > N) {
			if (result == 0) sb.append(tmp).append('\n');
			return;
		}
		
		// #1. 이어붙이기
		int newLast = (last > 0) ? (last * 10 + num) : (last * 10 - num);
		int newResult = result - last + newLast;
		DFS(num + 1, newLast, newResult, tmp + " " + num);
		
		// #2. 더하기
		DFS(num + 1, num, result + num, tmp + "+" + num);
		
		// #3. 빼기
		DFS(num + 1, -num, result - num, tmp + "-" + num);
	}
	
}
