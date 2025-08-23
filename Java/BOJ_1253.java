import java.io.*;
import java.util.*;

public class BOJ_1253 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			int target = nums[i];
			int left = 0;
			int right = N - 1;
			
			while (left < right) {
				if (left == i) {
					left++;
					continue;
				}
				
				if (right == i) {
					right--;
					continue;
				}
				
				int sum = nums[left] + nums[right];
				
				if (sum == target) {
					cnt++;
					break;
				} else if (sum < target) left++;
				else right--;
			}
		}
		
		System.out.println(cnt);
	}
}
