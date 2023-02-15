package SWEA.D4.정사각형방;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * 정사각형방
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc
 * 
 * 1. 모든 칸에 대해 얼마나 진행할 수 있는지 계산한다.
 * 2. 진행한 최대값과 첫 위치를 계산하고 저장한다.
 * 3. 1~2번을 반복하며 문제의 정답을 구한다.
 * 4. 사실 O(N^4)이라 안돌아갈 것 같은데 돌아간다.
 * 
 * @author 배용현
 *
 */
public class Solution {
	static int N;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int[] answer = {Integer.MAX_VALUE, Integer.MIN_VALUE};		// 시작 번호, 이동 거리
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int depth = dfs(i, j) - map[i][j] + 1;		// 막힌 부분의 값 - 현재 값
					if(depth>answer[1]) {		// 구한 이동거리가 최대일때
						answer[0] = map[i][j];		// 시작 위치 갱신
						answer[1] = depth;		// 이동거리 갱신
					} else if(depth==answer[1] && map[i][j]<answer[0]) {		// 구한 이동거리가 같으면 시작 위치가 작을때
						answer[0] = map[i][j];		// 시작위치 갱신
					}
				}
			}
			
			sb.append('#').append(tc).append(' ').append(answer[0]).append(' ').append(answer[1]).append('\n');
		}
		System.out.println(sb);
	}

	private static int dfs(int y, int x) {		// 막힌 부분의 값
		for(int i=0; i<4; i++) {
			int nextY = y+dy[i];
			int nextX = x+dx[i];
			
			if(nextX<0 || nextX>N-1 || nextY<0 || nextY>N-1 || map[nextY][nextX]!=map[y][x]+1)		// 못 들어가면 건너뛰기
				continue;
			
			return dfs(nextY, nextX);		// 들어갈 수 있으면 그 위치 탐색
		}
		
		return map[y][x];		// 더 이상 못 들어가면 해당 위치의 값 리턴
	}
}
