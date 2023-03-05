package SWEA.모의테스트.디저트카페;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * 디저트 카페
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5VwAr6APYDFAWu&categoryId=AV5VwAr6APYDFAWu&categoryType=CODE&problemTitle=SW&orderBy=RECOMMEND_COUNT&selectCodeLang=JAVA&select-1=&pageSize=10&pageIndex=1
 * 
 * 1. 모든 이동방향은 대각선이므로 이동 방향을 잘 설정한다.
 * 2. 먼저, 이중 반복을 돌면서 모든 칸에서 시작해봐야 한다.
 * 3. 각 칸에서 dfs로 경로를 찾되, 이전에 먹었던 디저트의 종류를 다시 먹을 수는 없으므로 크기가 100인 일차원 방문 배열을 이용한다.
 * 4. 경로를 찾을 때, 사각형을 그리며 돌아오기 위해서는 방향 회전을 모든 방향으로 한번씩 총 4번 해야한다.
 * 5. 한 번 방향을 정했을 때, 동일한 방향으로 최대한 많이 가는 것이 가장 디저트를 많이 먹을 수 있는 방법이다.
 * 6. 초기 위치를 도달했을 때의 depth의 최댓값을 저장한다.
 * 
 * @author byh98
 *
 */
public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, sourceY, sourceX, answer = 0;
	static int[][] map;
	static boolean[] eatenDessert;
	static int[] usedDirection;
	static int[] dx = {-1, 1, 1, -1};
	static int[] dy = {-1, -1, 1, 1};

	public static void main(String[] args) throws IOException {
		int T = parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			input();
			solution();
			sb.append('#').append(tc).append(' ').append(answer==2?-1:answer).append('\n');
		}
		
		System.out.println(sb);
	}
	
	private static void solution() {
		for(int i=0; i<N; i++) {		// 좌표 설정
			for(int j=0; j<N; j++) {
				sourceY = i;		// 출발지 
				sourceX = j;
				usedDirection = new int[4];		// 이용한 방향 (방문 처리가 여러번 되기 때문에 정수형으로 저장하여 구분)
				eatenDessert = new boolean[101];	// 먹은 디저트
				eatenDessert[map[i][j]] = true;		// 현재 위치의 디저트 먹음
				for(int k=0; k<4; k++) {		// 방향 설정
					usedDirection[k]++;		// 방향 방문 처리
					dfs(i, j, 0, k);
					usedDirection[k]--;		// 방향 방문 처리 해제
				}
			}
		}
	}

	private static void dfs(int y, int x, int depth, int dir) {
		int originDir = dir;		// 이번 칸에서 방향이 바뀌었는지 확인하기 위한 변수
		
		for(int i=0; i<4; i++) {		// 4가지 방향에 대해 탐색
			dir = (dir+i) % 4;		// 현재 방향을 우선으로 탐색
			int nx = x + dx[dir];		// 다음 x좌표
			int ny = y + dy[dir];		// 다음 y좌표
			
			if(isOut(nx, ny) || (originDir!=dir && usedDirection[dir]>0))		// 맵 범위를 벗어났거나 바뀐 방향이 이미 전진했던 방향이라면
				continue;
			
			if(sourceX==nx && sourceY==ny) {		// 다음 좌표가 출발지라면 정답 갱신하고 리턴
				answer = Math.max(answer, depth+1);
				return;
			}
			
			if(eatenDessert[map[ny][nx]])		// 다음 카페의 디저트 종류가 이미 먹었던 종류라면 전진 불가
				continue;
			
			usedDirection[dir]++;
			eatenDessert[map[ny][nx]] = true;
			dfs(ny, nx, depth+1, dir);
			usedDirection[dir]--;
			eatenDessert[map[ny][nx]] = false;
		}
		
	}

	private static boolean isOut(int nx, int ny) {
		return nx<0 || ny<0 || nx>N-1 || ny>N-1;
	}

	private static void input() throws IOException {
		N = parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				map[i][j] = parseInt(st.nextToken());
		}
		answer = 0;
	}
}
