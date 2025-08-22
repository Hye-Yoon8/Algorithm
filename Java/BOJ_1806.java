import java.io.*;
import java.util.*;

public class BOJ_1806 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == S) {
				System.out.println(1);
				return;
			}
		}
		
		int answer = Integer.MAX_VALUE;
		int left = 0, right = 0, sum = 0;
		while (left <= N && right <= N) {
			if (sum >= S && answer > (right - left)) {
				answer = right - left;
			}
			
			if (sum < S) sum += arr[right++];
			else sum -= arr[left++];
		}
		
		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}
}
