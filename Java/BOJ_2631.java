// 주요 알고리즘 : LIS (Longest Increasing Subsequence, 최장 증가 부분 수열)
// 핵심 아이디어 : 이미 오름차순인 최장 부분수열 길이를 L이라 하면, 나머지 N-L명만 옮기면 최소 이동 가능
// 개선 여지 : N이 커지면 이분 탐색 기반 O(N log N) LIS로 최적화 가능

import java.io.*;

public class BOJ_2631 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] kids = new int[N];
		for (int i = 0; i < N; i++) {
			kids[i] = Integer.parseInt(br.readLine());
		}
		
		int result = 0;
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (kids[i] > kids[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			result = Math.max(dp[i], result);
		}
		
		System.out.println(N - result);
	}
}
