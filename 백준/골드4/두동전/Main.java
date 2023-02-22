package 백준.골드4.두동전;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 두 동전
 * https://www.acmicpc.net/problem/16197
 *
 * 1. 동전이 2개이기 때문에 visited배열을 사용하기 어려운데 마침 버튼을 11회 이상 누르지 않는다고 한다.
 * 2. 따라서 위치를 기준으로 체크하지 않고 버튼을 누르는 행위를 기준으로 재귀를 호출한다.
 * 3. 재귀는 사방으로 움직이되 동전이 모두 밖으로 떨어지거나 움직인 동전이 없을 경우 백트래킹으로 처리한다.
 * 4. 동전 두 개의 좌표를 따로 저장해 놓는 것이 배열을 계속 순회하는 것보다 이득이다.
 *
 * @author 배용현
 *
 */
public class Main {

	static int N, M, answer = Integer.MAX_VALUE;
	static char[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());

		map = new char[N+2][M+2];		// 모든 모서리 패딩
		int[][] coinLocation = new int[2][2];		// 두 동전의 위치 (x, y)
		int coinIdx = 0;
		for(int i=1; i<=N; i++) {
			String input = br.readLine();
			for(int j=1; j<=M; j++) {
				map[i][j] = input.charAt(j-1);
				if(map[i][j]=='o')
					coinLocation[coinIdx++] = new int[] {j, i};
			}
		}

		for(int i=0; i<=N+1; i++)		// 출구 패딩 *
			map[i][M+1] = map[i][0] = '*';

		for(int i=0; i<=M+1; i++)		// 출구 패딩 *
			map[N+1][i] = map[0][i] = '*';

		recur(coinLocation, 0);		// 재귀로 찾기

		System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);		// 찾았으면 answer, 못 찾았으면 -1
	}

	private static void recur(int[][] coinLocation, int depth) {		// 버튼 누르는 시뮬레이션 재귀 메서드
		if(depth>=answer || depth==10)		// 가망이 없거나 10번을 눌러봤으면 리턴
			return;

		for(int i=0; i<4; i++) {
			int outNum = 0;		// 나간 동전 개수
			int[][] copiedCoinLocation = {{coinLocation[0][0], coinLocation[0][1]}, {coinLocation[1][0], coinLocation[1][1]}};		// 재귀호출할 때 갱신한거 넘겨야함

			for(int j=0; j<2; j++) {		// 두 동전의 상태 처리
				int nx = coinLocation[j][0] + dx[i];
				int ny = coinLocation[j][1] + dy[i];

				if(map[ny][nx]=='*') {		// 범위 밖으로 나갔으면
					outNum++;
				} else if(map[ny][nx]!='#') {		// 범위 안에서 이동 가능하면
					copiedCoinLocation[j][0] = nx;		// x좌표 갱신
					copiedCoinLocation[j][1] = ny;		// y좌표 갱신
				}
			}

			if(outNum==2) {		// 두 개 나갔으면
				continue;		// 다른 방향으로 다시 시도
			} else if(outNum==1) {		// 한 개 나갔으면
				answer = Math.min(answer, depth+1);		// 정답 갱신하고
				return;			// 리턴
			}

			recur(copiedCoinLocation, depth+1);		// 동전 이동 후 위치 넣어서 재귀 호출
		}
	}
}