import java.io.*;
import java.util.*;

public class BOJ_2179 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<String> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            if(!list.contains(word))
                list.add(word);
        }

        int resultStr1 = 0;
        int resultStr2 = 0;
        int maxCnt = 0;
        for(int i = 0; i < N; i++) {
            String str1 = list.get(i);
            for(int j = i + 1; j < N; j++) {
                int cnt = 0;
                String str2 = list.get(j);
                int size = Math.min(str1.length(), str2.length());
                
                for(int z = 0; z < size; z++) {
                    if(str1.charAt(z) == str2.charAt(z)) cnt++;
                    else break;
                }
                if(cnt > maxCnt) {
                    resultStr1 = i;
                    resultStr2 = j;
                    maxCnt = cnt;
                }
            }
        }

        System.out.println(list.get(resultStr1));
        System.out.println(list.get(resultStr2));
    }
}
