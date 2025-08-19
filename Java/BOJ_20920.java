import java.io.*;
import java.util.*;

public class BOJ_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<String> wordList = new ArrayList<>(map.keySet());

        wordList.sort((a, b) -> {
        	// #1. 빈도수
            int freqCompare = map.get(b) - map.get(a);
            if (freqCompare == 0) {
            	// #2. 길이
                int lenCompare = b.length() - a.length();
                
                // #3. 사전순
                if (lenCompare == 0) return a.compareTo(b);
                
                return lenCompare;
            }
            return freqCompare;
        });

        StringBuilder sb = new StringBuilder();
        for (String word : wordList) {
            sb.append(word).append("\n");
        }

        System.out.print(sb);
    }
}
