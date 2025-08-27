import java.io.*;

public class BOJ_15989_2 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[][] dp = new int [10001][4];
		dp[0][1] = 1;
		dp[0][2] = 1;
		dp[0][3] = 1;

		for (int i = 1; i <= 10000; i++) {
			// 1만 사용하는 경우
			dp[i][1] = 1;
			
			// 1,2만 사용하는 경우
			if (i >= 2) dp[i][2] = 1 + dp[i-2][2];
			else dp[i][2] = dp[i][1];
			
			// 1,2,3만 사용하는 경우
			if (i >= 3) dp[i][3] = dp[i][2] + dp[i-3][3];
			else dp[i][3] = dp[i][2];
		}
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n][3]).append("\n");
		}
		
		System.out.println(sb);
	}
}