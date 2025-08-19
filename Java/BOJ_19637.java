import java.io.*;
import java.util.*;

public class BOJ_19637 {
    static class Title {
        String name;
        int power;

        Title(String name, int power) {
            this.name = name;
            this.power = power;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 칭호 개수
        int M = Integer.parseInt(st.nextToken()); // 전투력 개수

        Title[] titles = new Title[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            titles[i] = new Title(name, power);
        }

        for (int i = 0; i < M; i++) {
            int val = Integer.parseInt(br.readLine());
            sb.append(binarySearch(titles, val)).append('\n');
        }

        System.out.print(sb);
    }

    static String binarySearch(Title[] titles, int target) {
        int left = 0;
        int right = titles.length - 1;
        String result = titles[right].name;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target <= titles[mid].power) {
                result = titles[mid].name;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
