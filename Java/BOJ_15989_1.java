import java.io.*;

public class BOJ_15989_1 {
	public static void main(String[] args) throws Exception {
		int[][] dp = new int[10001][4];
		dp[0][1] = 1;
		dp[0][2] = 1;
		dp[0][3] = 1;
		
		for (int i = 1; i <= 10000; i++) {
			// Use 1
			if (i-1 >= 0) dp[i][1] = dp[i-1][1];
			
			// Use 1, 2
			if (i-2 >= 0) dp[i][2] = dp[i][1] + dp[i-2][2];
			else dp[i][2] = dp[i][1];
			
			// Use 1, 2, 3
			if (i-3 >= 0) dp[i][3] = dp[i][2] + dp[i-3][3];
			else dp[i][3] = dp[i][2];
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n][3]).append("\n");
		}
		
		System.out.println(sb);
	}
}