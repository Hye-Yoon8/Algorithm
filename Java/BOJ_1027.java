import java.io.*;
import java.util.*;

public class BOJ_1027 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] heights = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			boolean hasMin = false, hasMax = false;
			int numMin = 0, denMin = 1;
			int numMax = 0, denMax = 1;
			
			for (int j = i - 1; j >= 0; j--) {
				int num = heights[i] - heights[j];
				int den = i - j;
				if (!hasMin || (long) (numMin * den) > (long) (denMin * num)) {
					cnt++;
					numMin = num; denMin = den;
					hasMin = true;
				}
			}
			
			for (int j = i + 1; j < N; j++) {
				int num = heights[j] - heights[i];
				int den = j - i;
				if (!hasMax || (long) (den * numMax) < (long) (denMax * num)) {
					cnt++;
					numMax = num; denMax = den;
					hasMax = true;
					
				}
			}
			
			result = Math.max(result, cnt);
		}
		
		System.out.println(result);
	}
}
