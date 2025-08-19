import java.io.*;
import java.util.*;

public class BOJ_2531 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 벨트에 놓인 접시의 수
		int d = Integer.parseInt(st.nextToken());	// 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken());	// 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken());	// 쿠폰 번호
		
		int[] sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		int[] now = new int[d + 1];
		for (int i = 0; i < k; i++) now[sushi[i]]++;
		int answer = cnt(now) + (now[c] == 0 ? 1 : 0);
		
		for (int i = 1; i < N; i++) {				
			now[sushi[(i-1) % N]]--;
			now[sushi[(i+k-1) % N]]++;
			
			answer = Math.max(answer, (cnt(now) + (now[c] == 0 ? 1 : 0)));
		}
		
		System.out.println(answer);
		br.close();
	}
	
	public static int cnt(int[] now) {
		int cnt = 0;
		for (int i = 1; i < now.length; i++) {
			if (now[i] != 0) cnt++;
		}
		return cnt;
	}
}
