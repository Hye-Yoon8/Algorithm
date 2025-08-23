import java.io.*;

public class BOJ_20310 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int num0 = 0;
        int num1 = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c);
            if (c == '0') num0++;
            else num1++;
        }

        num0 /= 2;
        num1 /= 2;

        // 1은 앞에서 제거
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                sb.setCharAt(i, '2');
                num1--;
            }
            if (num1 == 0) break;
        }

        // 0은 뒤에서 제거
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, '2');
                num0--;
            }
            if (num0 == 0) break;
        }

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '0' || c == '1') System.out.print(c);
        }
    }
}
