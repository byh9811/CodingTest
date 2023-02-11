package 백준.골드3.캐슬_디펜스;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 캐슬 디펜스
 * https://www.acmicpc.net/problem/17135
 * 
 * 1. M개의 칸 중 궁수를 배치할 칸 3개를 골라 시뮬레이션을 돌려본다.
 * 2. 궁수는 사거리 내의 적을 우선순위를 기준으로 공격하고, 해당 적은 소멸한다.
 * 3. 궁수의 공격이 끝나면 모든 적은 한칸 내려온다.
 * 4. 적이 맵 밖으로 벗어나면 해당 적은 그대로 제외된다.
 * 5. 모든 적이 사라질 때까지(그냥 N만큼 내리는 것을) 반복한다.
 * 6. 궁수를 배치하는 조합은 O(M^3), 모든 적을 내리며 공격하는 완전탐색, bfs는 O(NM+NM)인데 둘이 동시에 일어나므로 O(NM^4)의 시간복잡도를 가진다.
 * 7. N과 M의 최댓값이 15이므로 약 80만번의 연산으로 충분히 가능하다.
 * 
 * @author 배용현
 *
 */
public class Main {
	static class Point {		// 좌표와 거리를 저장하기 위해 클래스 선언
		int x;
		int y;
		int d;
		
		public Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	static int N, M, D;		// 행의 길이 N, 열의 길이 M, 궁수의 사거리 D
	static int[][] map, mapOrigin;		// 조합마다 새롭게 초기화될 map, 입력받은 초기값을 기억할 mapOrigin
	static int[] located;		// 조합으로 뽑은 세 궁수의 위치
	static boolean[][] visited;		// bfs용 방문체크배열
	static int[] dx = {-1, 0, 1, 0};		// x좌표 이동 배열
	static int[] dy = {0, -1, 0, 1};		// y좌표 이동 배열
	static int killed = 0;		// 전체 죽인 몹 수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());
		D = parseInt(st.nextToken());
		
		mapOrigin = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mapOrigin[i][j] = parseInt(st.nextToken());
			}
		}
		
		located = new int[3];		// 궁수는 3명임
		combination(0, 0);		// 조합으로 궁수의 자리를 지정
		System.out.println(killed);		// 킬 수의 최대값 출력
	}

	private static void combination(int depth, int start) {		// 궁수의 자리를 지정하는 용도의 비중복조합 재귀
		if(depth==3) {		// 조합을 완성했으면
			map = new int[N][M];		// 새 map 생성
			for(int i=0; i<N; i++) {		// 기존맵을 참고하여 새 맵 초기화
				for(int j=0; j<M; j++)
					map[i][j] = mapOrigin[i][j];
			}

			int kill = 0;		// 궁수 위치 배치 확정후 총 죽인 수
			for(int i=0; i<N; i++) {		// 적이 한칸씩 내려오므로 총 N번 반복
				kill += attack();		// 현재 턴에 공격 수행이후 죽인 적 수 더함
				move();		// 한칸씩 아래로 이동
			}
			killed = Math.max(kill, killed);		// 궁수 배치가 최적이었으면 죽인 수 저장

			return;
		}
		
		for(int i=start; i<M; i++) {		// 비중복조합 생성
			located[depth] = i;
			combination(depth+1, i+1);
		}
	}

	private static void move() {
		for(int i=N-1; i>0; i--) {		// 아래서부터 위쪽 행의 정보로 덮어씀
			for(int j=0; j<M; j++)
				map[i][j] = map[i-1][j];
		}
		for(int i=0; i<M; i++)		// 맨 윗열은 0으로 초기화
			map[0][i] = 0;
	}

	// 우선순위는 거리 > 왼쪽몹이다.
	// bfs를 이용해 사거리 내에 있는 몹을 선택한다.
	private static int attack() {		// 공격을 실시하는 메서드
		Point[] target = new Point[3];		// 이번 턴에 궁수가 잡을 적의 위치
		
		for(int t=0; t<3; t++) {
			Queue<Point> q = new LinkedList<>();		// bfs용 큐
			visited = new boolean[N][M];		// bfs용 방문배열
			q.add(new Point(located[t], N-1, 1));		// 궁수의 적 첫 탐색 위치
			int x = Integer.MAX_VALUE;		// 적을 찾았을때 무조건 값이 바뀔수 있도록 가장 큰 값으로 지정
			int y = Integer.MAX_VALUE;		// 적을 찾았을때 무조건 값이 바뀔수 있도록 가장 큰 값으로 지정
			int d = Integer.MAX_VALUE;		// 적을 찾았을때 무조건 값이 바뀔수 있도록 가장 큰 값으로 지정
			
			while(!q.isEmpty()) {		// 큐가 빌 때까지 적을 찾음
				Point p = q.poll();		// 현재 탐색중인 위치
				
				if(p.d>d)		// 이미 적을 찾은 거리보다 멀어지면 더 찾을 필요가 없다
					break;
				
				if(map[p.y][p.x]==1 && p.x<x) {		// 적이 존재하고, 우선순위 규칙에 의해 기존 x좌표보다 작은 경우 값을 변경
					x = p.x;
					y = p.y;
					d = p.d;
				}
				
				for(int i=0; i<4; i++) {		// 사방탐색
					int nextX = p.x + dx[i];		// 다음에 탐색할 X좌표
					int nextY = p.y + dy[i];		// 다음에 탐색할 Y좌표
					if(nextX>=0 && nextY>=0 && nextX<M && nextY<N && !visited[nextY][nextX] && p.d<D) {		// 유효값이며 방문안했고 사거리 안쪽이면
						q.add(new Point(nextX, nextY, p.d+1));		// 해당 위치 탐색
						visited[nextY][nextX] = true;		// 방문 체크
					}
				}
			}
			
			target[t] = d==Integer.MAX_VALUE ? null : new Point(x, y, d);		// 목표를 정했으면 위치좌표 저장
		}

		int kill = 0;		// 현재 공격턴에 적을 죽인 수
		for(int i=0; i<3; i++) {		// 3명의 궁수가 각 목표물을 쏜다
			if(target[i]!=null && map[target[i].y][target[i].x]!=0) {		// 목표가 존재하고, 해당 타겟을 앞 궁수가 죽이지 않았을 경우
				map[target[i].y][target[i].x] = 0;		// 타겟을 죽이고
				kill++;		// 킬 수를 1 증가시킴
			}
		}
		return kill;		// 현재 공격턴의 킬 수 리턴
	}
}
