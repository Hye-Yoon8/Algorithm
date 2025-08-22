import java.io.*;
import java.util.*;

public class BOJ_13144 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] isExist = new int[100001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int start = 0, end = 0;
		long total = 0;
		
		while (end < N) {
			while (isExist[arr[end]] > 0) {
				isExist[arr[start]]--;
				start++;
			}
			
			isExist[arr[end]]++;
			total += (end - start + 1);
			end++;
		}
		
		System.out.println(total);
	}
}
