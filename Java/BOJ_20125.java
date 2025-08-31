import java.io.*;

public class BOJ_20125 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        int headR = -1, headC = -1;
        outer:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '*') {
                    headR = i;
                    headC = j;
                    break outer;
                }
            }
        }

        int heartR = headR + 1;
        int heartC = headC;

        int leftArm = 0;
        for (int c = heartC - 1; c >= 0 && map[heartR][c] == '*'; c--) {
            leftArm++;
        }

        int rightArm = 0;
        for (int c = heartC + 1; c < N && map[heartR][c] == '*'; c++) {
            rightArm++;
        }

        int waist = 0;
        int r = heartR + 1;
        while (r < N && map[r][heartC] == '*') {
            waist++;
            r++;
        }
        int waistEndR = heartR + waist;

        int leftLeg = 0;
        for (int rr = waistEndR + 1; rr < N; rr++) {
            if (heartC - 1 >= 0 && map[rr][heartC - 1] == '*') leftLeg++;
            else break;
        }

        int rightLeg = 0;
        for (int rr = waistEndR + 1; rr < N; rr++) {
            if (heartC + 1 < N && map[rr][heartC + 1] == '*') rightLeg++;
            else break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append((heartR + 1)).append(' ').append((heartC + 1)).append('\n');
        sb.append(leftArm).append(' ')
          .append(rightArm).append(' ')
          .append(waist).append(' ')
          .append(leftLeg).append(' ')
          .append(rightLeg);

        System.out.print(sb.toString());
    }
}
