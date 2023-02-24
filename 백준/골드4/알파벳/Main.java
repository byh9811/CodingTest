package 백준.골드4.알파벳;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * 알파벳
 * https://www.acmicpc.net/problem/1987
 *
 * 1. dfs로 모든 경로를 탐색하며 최대 깊이를 저장한다.
 * 2. 단, 같은 알파벳은 통과할 수 없으므로 동일한 알파벳으로는 진행할 수 없다.
 * 
 * @author 배용현
 *
 */
public class Main {

	static int R, C, answer;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[][] map;
	static boolean[] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = parseInt(st.nextToken());
		C = parseInt(st.nextToken());

		map = new char[R][C];		// 맵 생성
		visited = new boolean['Z'-'A'+1];		// 알파벳 개수만큼 방문 배열 초기화
		for(int i=0; i<R; i++) {		// 맵 입력
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		visited[map[0][0]-'A'] = true;		// 첫 번째 문자 방문처리
		dfs(0, 0, 0);
		System.out.println(answer+1);
	}

	private static void dfs(int x, int y, int depth) {
		if(depth>answer)		// 기존보다 긴 경로를 찾았으면 갱신
			answer = depth;

		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx<0 || nx>C-1 || ny<0 || ny>R-1 || visited[map[ny][nx]-'A'])		// 들어갈 수 없는 곳이면 패스
				continue;

			visited[map[ny][nx]-'A'] = true;		// 해당 문자 방문체크
			dfs(nx, ny, depth+1);
			visited[map[ny][nx]-'A'] = false;		// 해당 문자 방문 해제
		}
	}
}