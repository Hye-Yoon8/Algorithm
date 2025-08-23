import java.io.*;

public class BOJ_2138 {
	static int N;
	static int[] now, target;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		now = new int[N];
		target = new int[N];
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		for (int i = 0; i < N; i++) {
			now[i] = s1.charAt(i) - '0';
			target[i] = s2.charAt(i) - '0';
		}
		
		int result = Math.min(run(true), run(false));
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	public static int run(boolean pressFirst) {
		int cnt = 0;
		int[] lights = now.clone();
		
		if (pressFirst) {
			press(lights, 0);
			cnt++;
		}
		
		for (int i = 1; i < N; i++) {
			if (lights[i-1] != target[i-1]) {
				press(lights, i);
				cnt++;
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (lights[i] != target[i]) return Integer.MAX_VALUE;
		}
		
		return cnt;
	}
	
	public static void press(int[] lights, int idx) {
		for (int i = idx - 1; i <= idx + 1; i++) {
			if (i >= 0 && i < N) lights[i] = 1 - lights[i];
		}
	}
}