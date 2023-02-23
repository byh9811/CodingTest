package 백준.실버1.영역구하기;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 영역 구하기
 * https://www.acmicpc.net/problem/2583
 *
 * 1. 입력이 좌표로 주어지므로 배열로 바꿀떄 주의한다.
 * 2. 입력을 처리하며 배열을 색칠한다.
 * 3. 색칠 안된 부분을 bfs로 색칠하며 영역의 개수와 크기를 센다.
 * 4. 영역의 개수는 따로 저장하며, 출력 전에 오름차순 정렬한다.
 * 
 * @author 배용현
 *
 */
public class Main {

	static int N, M;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static boolean[][] isFill;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		M = parseInt(st.nextToken());
		N = parseInt(st.nextToken());
		int K = parseInt(st.nextToken());
		
		isFill = new boolean[M][N];
		for(int i=0; i<K; i++) {		// 색칠할 도형
			st = new StringTokenizer(br.readLine());
			int sc = parseInt(st.nextToken());
			int sr = parseInt(st.nextToken());
			int ec = parseInt(st.nextToken());
			int er = parseInt(st.nextToken());
			
			for(int j=sr; j<er; j++) {
				for(int k=sc; k<ec; k++)		// 마지막 좌표를 포함하지 않으면 그대로 배열로 바꿀 수 있음
					isFill[j][k] = true;
			}
		}
		
		int sum = 0;		// 영역의 개수
		ArrayList<Integer> areas = new ArrayList<>();		// 영역의 넓이
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(isFill[i][j])		// 색칠되어 있으면 패스
					continue;
				
				sum++;		// 영역의 개수 1더하고
				areas.add(bfs(i, j));		// 해당 영역을 색칠하면서 개수 셈
			}
		}
		
		sb.append(sum).append('\n');
		areas.sort(null);		// 영역의 넓이 오름차순 정렬
		for(int elem: areas)
			sb.append(elem).append(' ');
		
		System.out.print(sb);
	}

	private static int bfs(int sy, int sx) {		// 영역 색칠
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {sx, sy});
		isFill[sy][sx] = true;
		int ret = 1;		// 영역의 넓이
		
		while(!q.isEmpty()) {
			int[] location = q.poll();
			for(int i=0; i<4; i++) {
				int nx = location[0] + dx[i];
				int ny = location[1] + dy[i];
				
				if(nx<0 || ny<0 || nx>N-1 || ny>M-1 || isFill[ny][nx])
					continue;
				
				q.add(new int[] {nx, ny});
				isFill[ny][nx] = true;
				ret++;
			}
		}
		
		return ret;
	}
}