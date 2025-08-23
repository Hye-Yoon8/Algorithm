import java.io.*;
import java.util.*;

public class BOJ_9935 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		
		Deque<Character> stack = new ArrayDeque<>();
		int bombLen = bomb.length();
        
        for (int i = 0; i < str.length(); i++) {
            stack.addLast(str.charAt(i));

            // 스택 크기가 폭탄 문자열보다 같거나 클 때만 검사
            if (stack.size() >= bombLen) {
                boolean isBomb = true;
                Iterator<Character> it = stack.descendingIterator(); // 끝에서부터 bomb 길이만큼 확인
                for (int j = bombLen - 1; j >= 0; j--) {
                    if (!it.hasNext() || it.next() != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    for (int j = 0; j < bombLen; j++) {
                        stack.removeLast();
                    }
                }
            }
        }

        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) sb.append(c);
            System.out.println(sb);
        }
	}
}
