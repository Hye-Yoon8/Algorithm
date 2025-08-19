import java.io.*;
import java.util.*;

public class BOJ_2467 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 전체 용액의 수
		
		Long[] list = new Long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Long.parseLong(st.nextToken());
		}
		
		int start = 0, end = N-1;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		Long result = Long.MAX_VALUE;
		
		while (end > start) {
			Long tmp = list[start] + list[end];
			
			if (tmp == 0) {
				min = start;
				max = end;
				break;
			}
			
			if (tmp > 0) {
				if (Math.abs(tmp) < Math.abs(result)) {
					result = tmp;
					min = start;
					max = end;
				}
				end--;
			}
			
			else if (tmp < 0) {
				if (Math.abs(tmp) < Math.abs(result)) {
					result = tmp;
					min = start;
					max = end;
				}
				start++;
			}
		}
		
		System.out.println(list[min] + " " + list[max]);
	}
}