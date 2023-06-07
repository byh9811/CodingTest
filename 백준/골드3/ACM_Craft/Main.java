package 백준.골드3.ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * ACM Craft
 * https://www.acmicpc.net/problem/1005
 *
 * 1. 이전에 건설해야할 건물의 정보를 방향 그래프로 저장해두고 이를 이용해 다익스트라를 사용하면 될 것 같다.
 * 2. 연결리스트를 사용하여 그래프를 구현해보자.
 * -------------------------------------------------
 * 1. 이전 건물이 둘 중 하나만 건설되면 되는게 아니라 둘 다 건설되어야 하므로 위의 방법을 사용할 수 없다.
 * 2. 따라서 각 건물을 짓기 위한 선행 건물의 정보를 저장하고, 해당 건물이 건설되었는지 확인한뒤 가능한 건물을 건설하는 방법을 사용하면 될 것 같다.
 * 3. 총 간선의 수만큼만 비교연산을 수행하게 되어 O(K)의 시간복잡도를 가지므로 통과 가능하다.
 * 
 * @author 배용현
 *
 */
public class Main {

	static int N, K, W;
	static int[] time, accTime, remainPrev;
	static ArrayList<Integer>[] edge;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			input();
			sb.append(solution()).append('\n');
		}
		System.out.print(sb);
	}

	private static int solution() {
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			accTime[i] = time[i];

			if (remainPrev[i] == 0) {		// 가장 먼저 건설할 수 있는 건물이면
				q.add(i);		// 큐에 삽입
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : edge[cur]) {
				accTime[next] = Math.max(accTime[next], accTime[cur] + time[next]);		// 다른 사전 건물을 짓는 시간과 cur 사전 건물을 짓는 시간 중 최종적으로 긴 시간이 소요됨
				remainPrev[next]--;		// cur가 건설되었으면 next의 사전건물 개수 - 1
				if (remainPrev[next] == 0) {		// 사전 건물이 모두 건설되었으면
					q.add(next);		// 큐에 추가
				}
			}
		}

		return accTime[W];
	}

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = parseInt(st.nextToken());
		K = parseInt(st.nextToken());

		time = new int[N + 1];
		accTime = new int[N + 1];
		remainPrev = new int[N + 1];
		edge = new ArrayList[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			time[i] = parseInt(st.nextToken());
			edge[i] = new ArrayList<>();
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int start = parseInt(st.nextToken());
			int end = parseInt(st.nextToken());
			edge[start].add(end);		// 사전 건설 건물의 정보 입력
			remainPrev[end]++;		// end를 짓는데 필요한 사전 건물의 수 갱신
		}

		W = parseInt(br.readLine());
	}


}