import java.io.*;
import java.util.*;

public class BOJ_1446 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 지름길의 개수
		int D = Integer.parseInt(st.nextToken());	// 고속도로의 길이
		
		List<int[]> shortcut = new ArrayList<>();
		for (int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());	// 지름길의 시작 위치
			int end = Integer.parseInt(st.nextToken());		// 지름길의 도착 위치
			int length = Integer.parseInt(st.nextToken());	// 지름길의 길이
			
			shortcut.add(new int[] {start, end, length});
		}
		
		int[] arr = new int[D+1];
		for (int i = 0; i <= D; i++) arr[i] = i;
		for (int i = 1; i <= D; i++) {
			arr[i] = arr[i-1] + 1;
			for (int[] sc : shortcut) {
				if (sc[1] == i) arr[i] = Math.min(arr[i], arr[sc[0]] + sc[2]);
			}
		}
		
		System.out.println(arr[D]);
	}
}