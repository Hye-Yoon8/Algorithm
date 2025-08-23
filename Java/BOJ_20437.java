import java.io.*;
import java.util.*;

public class BOJ_20437 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			
			if (K == 1) {
				sb.append("1 1\n");
				continue;
			}
			
			// 문자별 위치 저장
			Map<Character, List<Integer>> map = new HashMap<>();
			for (int i = 0; i < W.length(); i++) {
				map.computeIfAbsent(W.charAt(i), value -> new ArrayList<>()).add(i);
			}
			
			int minLen = Integer.MAX_VALUE;
			int maxLen = Integer.MIN_VALUE;
			
			for (char c : map.keySet()) {
				List<Integer> index = map.get(c);
				
				if (index.size() < K) continue;
				
				for (int i = 0; i <= index.size() - K; i++) {
					int len = index.get(i + K - 1) - index.get(i) + 1;
					minLen = Math.min(minLen, len);
					maxLen = Math.max(maxLen, len);
				}
			}
			
			if (minLen == Integer.MAX_VALUE) sb.append("-1\n");
			else sb.append(minLen).append(" ").append(maxLen).append("\n");
		}
		
		System.out.println(sb);
	}
}
