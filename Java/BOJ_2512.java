import java.io.*;
import java.util.*;

public class BOJ_2512 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] budgets = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			budgets[i] = Integer.parseInt(st.nextToken());
			if (budgets[i] > max) max = budgets[i];
		}

		int M = Integer.parseInt(br.readLine());

		int low = 0;
		int high = max;
		int answer = 0;

		while (low <= high) {
			int mid = (low + high) / 2;
			long total = 0;

			for (int b : budgets) {
				total += Math.min(b, mid);
			}

			if (total <= M) {
				answer = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		System.out.println(answer);
	}
}
