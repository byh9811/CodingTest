package 백준.골드3.다리만들기;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 다리 만들기
 * https://www.acmicpc.net/problem/2146
 * 
 * 1. bfs로 각 섬에 번호를 붙인다.
 * 2. 섬에 모든 부분에서 bfs를 수행하여 다음 섬으로 가는 최소 거리를 구한다.
 * 3. 모든 다리 길이의 최솟값을 저장하여 출력한다.
 * 
 * @author 배용현
 *
 */
public class Main {
	static int N, answer = Integer.MAX_VALUE;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				map[i][j] = parseInt(st.nextToken());
		}
		
		int groupNum = 2;		// 0과 1은 이미 사용하고 있으므로 2부터 그룹번호로 지정
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]!=1)		// 바다거나 이미 처리한 육지면 패스
					continue;
			
				setGroup(i, j, groupNum++);		// 처리되지 않은 육지면 bfs 메서드 실행
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0)		// 바다면 패스
					continue;
			
				answer = Math.min(answer, getMinBridge(i, j));		// 처리되지 않은 육지면 bfs 메서드 실행
			}
		}
		
		System.out.println(answer);
	}
	
	private static int getMinBridge(int sy, int sx) {		// 현재 위치에서 다른 섬으로 가는 최단 거리
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new ArrayDeque<>();		// 0: x좌표, 1: y좌표, 2: depth
		q.add(new int[] {sx, sy, 0});		// 초기 위치 지정
		visited[sy][sx] = true;		// 방문 처리
		int groupNum = map[sy][sx];		// 시작 위치의 그룹 번호
		
		while(!q.isEmpty()) {
			int[] point = q.poll();
			int x = point[0];
			int y = point[1];
			int d = point[2];
			
			if(map[y][x]!=groupNum && map[y][x]!=0)		// 새로운 섬에 도달하면
				return d-1;		// 다리의 길이는 거리-1
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<0 || ny<0 || nx>N-1 || ny>N-1 || visited[ny][nx] || map[ny][nx]==groupNum)		// 유효한 범위이고, 섬의 내륙부분인 경우 패스
					continue;
				
				q.add(new int[] {nx, ny, d+1});		// 해당 칸 큐에 넣고
				visited[ny][nx] = true;		// 방문 처리
			}
		}
		
		return Integer.MAX_VALUE;		// 못 찾을리는 없지만 문법상 넣어줌
	}

	private static void setGroup(int sy, int sx, int groupNum) {		// 각 섬에 그룹 번호를 부여하는 메서드
		Queue<int[]> q = new ArrayDeque<>();		// 0: x좌표, 1: y좌표
		q.add(new int[] {sx, sy});		// 초기 위치 지정
		map[sy][sx] = groupNum;		// 그룹 번호로 변경
		
		while(!q.isEmpty()) {
			int[] point = q.poll();
			
			for(int i=0; i<4; i++) {
				int x = point[0] + dx[i];
				int y = point[1] + dy[i];
				
				if(x<0 || y<0 || x>N-1 || y>N-1 || map[y][x]!=1)		// 아직 그룹번호로 바꾸지 못한 칸이 아니면 패스
					continue;
				
				q.add(new int[] {x, y});		// 해당 칸 큐에 넣고
				map[y][x] = groupNum;		// 그룹 번호로 변경
			}
		}
	}

}