package 백준.실버1.숨바꼭질;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 숨바꼭질
 * https://www.acmicpc.net/problem/1697
 *
 * 1. 수빈이가 움직일 수 있는 위치를 큐에 넣으며 bfs를 실행한다.
 * 2. 이미 도달했던 위치는 방문배열을 이용해 다시 가지 않도록 설정한다.
 * 
 * @author 배용현
 *
 */
public class Main {

	static final int MAX = 100000;		// MAX 10만
	static int N, K;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static boolean[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = parseInt(st.nextToken());
		K = parseInt(st.nextToken());
		
		visited = new boolean[MAX+1];		// 범위가 0~100,000이므로 MAX+1 만큼 초기화
		System.out.println(bfs());		// bfs 
	}

	private static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {N, 0});
		visited[N] = true;		// 방문 체크
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0]==K)
				return cur[1];
			
			if(cur[0]>=1 && !visited[cur[0]-1]) {		// 한칸 전으로 이동할 수 있으면 이동
				visited[cur[0]-1] = true;
				q.add(new int[] {cur[0]-1, cur[1]+1});
			}
			
			if(cur[0]<=MAX-1 && !visited[cur[0]+1]) {		// 한칸 후로 이동할 수 있으면 이동
				visited[cur[0]+1] = true;
				q.add(new int[] {cur[0]+1, cur[1]+1});
			}
			
			if(cur[0]*2<=MAX && !visited[cur[0]*2]) {		// 두 배의 칸으로 이동할 수 있으면 이동
				visited[cur[0]*2] = true;
				q.add(new int[] {cur[0]*2, cur[1]+1});
			}
		}
		
		return -1;		// 사실상 안들어감
	}
}