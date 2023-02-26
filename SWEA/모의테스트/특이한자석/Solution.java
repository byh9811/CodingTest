package SWEA.모의테스트.특이한자석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * 특이한 자석
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH
 *
 * 1. 자석이 회전하는 메서드를 만든다.
 * 	- 인덱스 3개를 봐야되고 회전도 해야되므로 자석의 극을 저장하는 구조를 따로 만들어버리자.
 * 	- 각각의 자석은 배열로 관리하면 될 것 같다.
 * 2. 시작 자석을 회전시키고, dfs를 이용해 연쇄적인 회전을 구현한다.
 *  - 방문 배열을 초기화하면서 양 옆의 자석을 재귀로 탐색해서 회전하면 될 것 같다.
 * 3. 모든 회전이 끝나면 자석의 상태를 이용해 점수를 계산한다.
 *  - Deque의 peek가 S면 (2^자석 인덱스)만큼 점수에 더한다.
 *
 * @author 배용현
 *
 */
public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static boolean[][] poles;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		int T = parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int K = parseInt(br.readLine());		// 회전 수
			poles = new boolean[4][8];		// 자석은 4개, 극은 총 8개 존재
			for(int i=0; i<4; i++) {		// 자석의 극 정보 초기화
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++)
					poles[i][j] = st.nextToken().equals("1");		// 1 = S극 = True
			}

			for(int i=0; i<K; i++) {
				visited = new boolean[4];		// 자석 방문 체크용
				st = new StringTokenizer(br.readLine());
				int idx = parseInt(st.nextToken()) - 1;		// 자석 인덱스
				boolean clockwiseDirection = st.nextToken().equals("1");		// 시계 방향
				dfs(idx, clockwiseDirection);
			}

			sb.append('#').append(tc).append(' ').append(getScore()).append('\n');
		}

		System.out.print(sb);
	}

	private static int getScore() {		// 점수 계산
		int sum = 0;		// 4개 자석의 총 점수
		int base = 1;		// 이번 자석에서 얻을 수 있는 점수

		for(int i=0; i<4; i++) {
			if(poles[i][0])		// 맨 위가 S극이면
				sum += base;

			base *= 2;
		}

		return sum;
	}

	private static void dfs(int idx, boolean clockwiseDirection) {
		visited[idx] = true;		// 방문 처리하고
		rotate(idx, clockwiseDirection);		// 회전

		// 시계방향으로 돌면 현재의 7과, 반시계방향으로 돌면 현재의 5와 왼쪽의 2와 비교
		if(idx>0 && !visited[idx-1] && ((clockwiseDirection ? poles[idx][7] : poles[idx][5]) != poles[idx-1][2]))
			dfs(idx-1, !clockwiseDirection);

		// 시계방향으로 돌면 현재의 3과, 반시계방향으로 돌면 현재의 1과 왼쪽의 6와 비교
		if(idx<3 && !visited[idx+1] && ((clockwiseDirection ? poles[idx][3] : poles[idx][1]) != poles[idx+1][6]))
			dfs(idx+1, !clockwiseDirection);
	}

	private static void rotate(int idx, boolean clockwiseDirection) {		// 자석을 회전하는 메서드
		if(clockwiseDirection)		// 방향에 따라 분기
			rotateClockwise(idx);
		else
			rotateCounterclockwise(idx);
	}

	private static void rotateClockwise(int idx) {		// 시계 방향으로 회전하는 메서드
		boolean temp = poles[idx][7];		// 마지막 극은 따로 저장

		for(int i=7; i>0; i--)
			poles[idx][i] = poles[idx][i-1];

		poles[idx][0] = temp;
	}

	private static void rotateCounterclockwise(int idx) {		// 반시계 방향으로 회전하는 메서드
		boolean temp = poles[idx][0];		// 첫 극은 따로 저장

		for(int i=0; i<7; i++)
			poles[idx][i] = poles[idx][i+1];

		poles[idx][7] = temp;
	}

}