import java.io.*;

public class BOJ_1283 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] isCheck = new boolean[26]; // A~Z 사용 여부

		for (int i = 0; i < N; i++) {
			String cmd = br.readLine();
			String[] words = cmd.split(" ");
			boolean assigned = false;

			// 1. 단어의 첫 글자부터 확인
			for (int j = 0; j < words.length; j++) {
				char c = Character.toLowerCase(words[j].charAt(0));
				if (!isCheck[c - 'a']) {
					isCheck[c - 'a'] = true;
					words[j] = "[" + words[j].charAt(0) + "]" + words[j].substring(1);
					assigned = true;
					break;
				}
			}

			if (assigned) {
				// 단축키가 설정된 경우 전체 문장 재조합하여 출력
				for (int j = 0; j < words.length; j++) {
					sb.append(words[j]);
					if (j != words.length - 1) sb.append(" ");
				}
				sb.append("\n");
				continue;
			}

			// 2. 전체 문자열 왼쪽부터 탐색
			boolean done = false;
			for (int j = 0; j < cmd.length(); j++) {
				char c = cmd.charAt(j);
				if (c == ' ') continue;
				char lower = Character.toLowerCase(c);
				if (!isCheck[lower - 'a']) {
					isCheck[lower - 'a'] = true;
					sb.append(cmd.substring(0, j));
					sb.append("[");
					sb.append(cmd.charAt(j));
					sb.append("]");
					sb.append(cmd.substring(j + 1));
					sb.append("\n");
					done = true;
					break;
				}
			}

			if (!done) {
				sb.append(cmd).append("\n"); // 단축키를 지정할 수 없는 경우
			}
		}

		System.out.print(sb);
	}
}
