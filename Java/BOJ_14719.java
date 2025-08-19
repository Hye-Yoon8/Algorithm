import java.io.*;
import java.util.*;

public class BOJ_14719 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());	// 세로 길이
		int W = Integer.parseInt(st.nextToken());	// 가로 길이

		int[] worlds = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int h = Integer.parseInt(st.nextToken());
			worlds[i] = h;
		}
		
		int answer = 0;
		for (int i = 1; i < W-1; i++) {
			int left = 0;
			int right = 0;
			
			for (int j = 0; j <= i; j++) {
				left = Math.max(left, worlds[j]);
			}

			for (int j = i+1; j < W; j++) {
				right = Math.max(right, worlds[j]);
			}
			
			int height = Math.min(left, right) - worlds[i];
			if (height > 0) answer += height;
		}
		
		System.out.println(answer);
	}
}