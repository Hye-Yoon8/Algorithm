import java.io.*;

public class BOJ_1522 {
	public static void main(String[] args) throws Exception {
		String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
		
		if (str.length() < 4) {
			System.out.println(0);
			return;
		}
		
		int aTotal = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') aTotal++;
		}
		
		int aMax = 0;
		for (int i = 0; i < str.length(); i++) {
			int aCnt = 0;
			for (int j = i; j < i + aTotal; j++) {
				if (str.charAt(j % str.length()) == 'a') aCnt++;
			}
			aMax = Math.max(aMax, aCnt);
		}
		
		System.out.println(aTotal - aMax);
	}
}
