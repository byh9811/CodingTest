package 백준.실버2.BFS와DFS;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * DFS와 BFS
 * https://www.acmicpc.net/problem/1260
 *
 * 1. 그래프를 행렬로 구현하고 DFS와 BFS를 수행한다.
 * 2. bfs는 익숙해서 바로바로 나오는데 dfs가 익숙하지 않고 그냥 백트래킹이랑 헷갈린다. 공부 더해야 될 듯
 * 
 * @author 배용현
 *
 */
public class Main {

	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static boolean[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = parseInt(st.nextToken());		// 노드의 수
		int M = parseInt(st.nextToken());		// 간선의 수
		int V = parseInt(st.nextToken());		// 시작 노드 번호

		map = new boolean[N+1][N+1];		// 노드번호가 1부터 시작하므로 0번 버리고 N+1
		visited = new boolean[N+1];			// 마찬가지로 N+1
		for(int i=0; i<M; i++) {		// 간선 정보로 행렬 만듬
			st = new StringTokenizer(br.readLine());
			int v1 = parseInt(st.nextToken());;
			int v2 = parseInt(st.nextToken());;
			
			map[v1][v2] = true;
			map[v2][v1] = true;
		}

		dfs(V);
		sb.append('\n');
		bfs(V);
		
		System.out.println(sb);
	}

	private static void bfs(int start) {
		visited = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(' ');

			for(int i=1; i<N+1; i++) {
				if(!map[cur][i] || visited[i])		// 노드가 연결되어있지 않거나 이미 방문한 노드면 패스
					continue;

				q.add(i);		// 큐에 넣고 
				visited[i] = true;		// 방문처리 한다음 bfs 준비
			}
		}
	}

	private static void dfs(int cur) {
		visited[cur] = true;		// 방문 체크하고
		sb.append(cur).append(' ');		// 출력에 추가
		
		for(int i=1; i<N+1; i++) {		// 다음 노드에 대해
			if(!map[cur][i] || visited[i])		// 노드가 연결되어있지 않거나 이미 방문한 노드면 패스
				continue;
			
			dfs(i);		// 아니면 그 노드로 들어감
		}
	}

}