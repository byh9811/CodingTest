package SWEA.D3.체스판_위의_룩배치;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 1. boolean타입 2차원 배열로 생성한다.
 * 2. 맵을 돌면서 룩이 나오면 해당 행과 열에 다른 룩이 있는지 검사한다.
 * 3. 다른 룩이 없고, 룩이 총 8개이면 yes를 출력하고 하나라도 만족하지 못할 경우 no를 출력한다.
 */
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++) {
			boolean[][] map = new boolean[8][8];		// 룩 있으면 true, 없으면 false
			for(int i=0; i<8; i++) {
				String input = br.readLine();
				for(int j=0; j<8; j++) {
					map[i][j] = input.charAt(j)=='O' ? true : false;
				}
			}
			
			boolean okay = true;
			int cnt = 0;
			for(int i=0; i<8; i++) {
				for(int j=0; j<8; j++) {
					if(map[i][j]) {
						cnt++;
						if(!isOkay(map, i, j)) {
							okay = false;
							break;
						}
					}
				}
				
				if(!okay)
					break;
			}
			
			System.out.printf("#%d %s\n", t, okay && cnt==8 ? "yes" : "no");
		}
	}

	private static boolean isOkay(boolean[][] map, int y, int x) {
		for(int i=0; i<8; i++) {
			if((i!=x && map[y][i]) || (i!=y && map[i][x])) {
				return false;
			}
		}
		
		return true;
	}
}
