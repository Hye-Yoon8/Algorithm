import java.io.*;

public class BOJ_7682 {
	static char[][] board;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String st = br.readLine();
			if (st.equals("end")) break;
			
			board = new char[3][3];
			int xCnt = 0;
			int oCnt = 0;
			int idx = 0;
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					board[i][j] = st.charAt(idx++);
					if (board[i][j] == 'X') xCnt++;
					else if (board[i][j] == 'O') oCnt++;
				}
			}

			if (xCnt == oCnt + 1) {		// X 승리
				if (xCnt + oCnt == 9 && !bingo('O')) sb.append("valid").append("\n");
				else if (!bingo('O') && bingo('X')) sb.append("valid").append("\n");
				else sb.append("invalid").append("\n");
			}
			
			else if (xCnt == oCnt) {	// O 승리
				if (!bingo('X') && bingo('O')) sb.append("valid").append("\n");
                else sb.append("invalid").append("\n");
			}
			
			else sb.append("invalid").append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static boolean bingo(char c) {
		// 가로 빙고
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == c && board[i][1] == c && board[i][2] == c) return true;
		}
		
		// 세로 빙고
		for (int i = 0; i < 3; i++) {
			if (board[0][i] == c && board[1][i] == c && board[2][i] == c) return true;
		}
		
		// 대각선 빙고
		if (board[0][0] == c && board[1][1] == c && board[2][2] == c) return true;
		if (board[0][2] == c && board[1][1] == c && board[2][0] == c) return true;
		
		return false;
	}

}
