import java.io.*;
import java.util.*;

public class BOJ_3758 {
	
	static class Team {
		int id;
		int[] scores;
		int totalScore;
		int submission;
		int lastSubmit;
		
        public Team(int id, int k) {
            this.id = id;
            this.scores = new int[k + 1];
            this.totalScore = 0;
            this.submission = 0;
            this.lastSubmit= 0;
        }
        
        public void submit(int prob, int score, int time) {
        	submission++;
        	if (score > scores[prob]) {
        		totalScore += (score - scores[prob]);
        		scores[prob] = score;
        	}
        	lastSubmit = time;
        }
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());	// 팀의 개수
			int k = Integer.parseInt(st.nextToken());	// 문제의 개수
			int t = Integer.parseInt(st.nextToken());	// 우리 팀의 ID
			int m = Integer.parseInt(st.nextToken());	// 로그 엔트리의 개수
			
			Map<Integer, Team> teams = new HashMap<>();
			for (int i = 1; i <= n; i++) teams.put(i, new Team(i, k));
			
			for (int time = 0; time < m; time++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				teams.get(i).submit(j, s, time);
			}
			
			List<Team> teamList = new ArrayList<>(teams.values());
			
			teamList.sort((a, b) -> {
				if (a.totalScore != b.totalScore) return b.totalScore - a.totalScore;
				if (a.submission != b.submission) return a.submission - b.submission;
				return a.lastSubmit - b.lastSubmit;
			});
			
			for (int i = 0; i < teamList.size(); i++) {
				if (teamList.get(i).id == t) {
					System.out.println(i + 1);
					break;
				}
			}
		}
	}

}
