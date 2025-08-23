import java.io.*;
import java.util.*;

public class BOJ_20055 {
	static int N, K;
	static int[] belt;
	static boolean[] robot;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		belt = new int[2 * N];
		robot = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2*N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		int step = 0;
		while (true) {
			step++;
			
			// Step 1. Rotate belt + robot
			rotate();
			
			// Step 2. Move Robots
			moveRobots();
			
			// Step 3. Put Robot
			if (belt[0] > 0) {
				robot[0] = true;
				belt[0]--;
			}
			
			// Step 4. Count Durability 0 Cell
			int cnt = 0;
			for (int d : belt) if (d == 0) cnt++;
			if (cnt >= K) break;
		}
		
		System.out.println(step);
	}
	
	static void rotate() {
        // 벨트 회전
        int tmp = belt[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = tmp;

        // 로봇 회전
        for (int i = N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        robot[N - 1] = false; // 로봇 내리는 곳
	}
	
	static void moveRobots() {
        for (int i = N - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && (belt[i + 1] > 0)) {
                robot[i] = false;
                robot[i + 1] = true;
                belt[i + 1]--;

                if (i + 1 == N - 1) robot[i + 1] = false;
            }
        }
    }
}
