import java.io.*;
import java.util.*;

public class BOJ_11501 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			int[] stocks = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				stocks[i] = Integer.parseInt(st.nextToken());
			}

			long result = 0L;
			int maxPrice = 0;
			
			for (int i = N - 1; i >= 0; i--) {
				if (stocks[i] > maxPrice) maxPrice = stocks[i];
				else result += (maxPrice - stocks[i]);
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}
}
