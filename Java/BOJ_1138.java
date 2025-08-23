import java.io.*;
import java.util.*;

public class BOJ_1138 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] heights = new int[N];
		for (int i = 0; i < N; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}

		int[] result = new int[N];

		for (int i = 0; i < N; i++) {
			int taller = heights[i];

			for (int j = 0; j < N; j++) {
				if (result[j] == 0) {
					if (taller == 0) {
						result[j] = i + 1;
						break;
					}
					taller--;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int num : result) {
			sb.append(num).append(" ");
		}
		System.out.println(sb.toString().trim());
	}
}
