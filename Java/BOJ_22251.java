import java.io.*;
import java.util.*;

public class BOJ_22251 {
	
	static String[] SEGMENTS = {
		    "1111110", // 0
		    "0110000", // 1
		    "1101101", // 2
		    "1111001", // 3
		    "0110011", // 4
		    "1011011", // 5
		    "1011111", // 6
		    "1110000", // 7
		    "1111111", // 8
		    "1111011"  // 9
		};
	
	static int[][] diff = new int[10][10];	// // i를 j로 바꾸기 위해 반전시켜야 하는 LED 개수
    static int N, K, P, X;
    static int[] nowDigits;
    static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 1층부터 N층까지 이용 가능한 엘리베이터
		K = Integer.parseInt(st.nextToken());	// 디스플레이에는 K 자리의 수가 출력
		P = Integer.parseInt(st.nextToken());	// 최대 P개를 반전
		X = Integer.parseInt(st.nextToken());	// 실제 멈춰있는 층 X
		
		initDiff();
		
		nowDigits = new int[K];
        String now = String.format("%0" + K + "d", X);	// 현재 층
        for (int i = 0; i < K; i++) nowDigits[i] = now.charAt(i) - '0';
        
        DFS(0, 0, new int[K]);
        System.out.println(result);
	}
	
	static void initDiff() {
	    for (int i = 0; i < 10; i++) {
	        for (int j = 0; j < 10; j++) {
	            int cnt = 0;
	            for (int k = 0; k < 7; k++) {
	                if (SEGMENTS[i].charAt(k) != SEGMENTS[j].charAt(k)) cnt++;
	            }
	            diff[i][j] = cnt;
	        }
	    }
	}
	
	static void DFS(int k, int total, int[] candidate) {
		if (total > P) return;
		
		if (k == K) {
			int num = 0;
			for (int c : candidate) num = num * 10 + c;
			if (num >= 1 && num <= N && num != X) result++;
			return;
		}
		
		for (int d = 0; d <= 9; d++) {
			candidate[k] = d;
			DFS(k + 1, total + diff[nowDigits[k]][d], candidate);
		}
	}

}
