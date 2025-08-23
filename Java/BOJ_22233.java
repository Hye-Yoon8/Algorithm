import java.io.*;
import java.util.*;

public class BOJ_22233 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 메모장에 쓴 키워드 개수
		int M = Integer.parseInt(st.nextToken());	// 블로그에 쓴 글의 개수

		Set<String> txt = new HashSet<>();
		for (int i = 0; i < N; i++) {
			txt.add(br.readLine());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String[] words = br.readLine().split(",");
			for (String word : words) txt.remove(word);
			sb.append(txt.size()).append("\n");
		}

		System.out.print(sb);
	}
}
