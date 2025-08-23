import java.io.*;

public class BOJ_12919 {
	static String S, T;
	static boolean answer = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		
		DFS(T);
		System.out.println(answer ? 1 : 0);
	}
	
	public static void DFS(String now) {
		if (answer) return;
		
		if (now.equals(S)) {
			answer = true;
			return;
		}
		
		if (now.length() < S.length()) return;
		
		// 1. T의 맨 뒤가 'A' → 마지막 'A' 제거
		if (now.charAt(now.length() - 1) == 'A') {
			DFS(now.substring(0, now.length() - 1));
		}
		
		// 2. T의 맨 앞이 'B' → 'B' 제거 후 뒤집기
		if (now.charAt(0) == 'B') {
			DFS(new StringBuilder(now.substring(1)).reverse().toString());
		}
	}
}
