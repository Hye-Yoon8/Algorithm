import java.io.*;
import java.util.*;

public class BOJ_10431 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int P = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while (P-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			
			int steps = 0;
			int[] heights = new int[20];
			
			for (int i = 0; i < 20; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j < i; j++) {
					if (heights[i] < heights[j]) {
						steps++;
					}
				}
			}
			
			sb.append(T).append(" ").append(steps).append("\n");
		}
		
		System.out.println(sb);
	}
}
