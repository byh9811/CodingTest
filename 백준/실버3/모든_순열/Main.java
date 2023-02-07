package 백준.실버3.모든_순열;

import java.io.*;

/**
 * 모든 순열
 * https://www.acmicpc.net/problem/10974
 *
 * 1. N을 입력받고 재귀를 이용하여 모든 순열을 출력한다.
 * 2. int형 배열에 원소를 넣으면서 재귀하다가 depth가 N일때 출력하면 될 것 같다.
 * 3. 한 번 사용한 숫자는 다시 사용할 수 없으므로 boolean형 배열로 방문체크한다.
 *
 * @author 배용현
 */
public class Main {
	static int[] selected;		// 선택된 숫자들이 저장될 배열
	static boolean[] visited;		// 방문체크를 위한 배열
	static int N;		// 사용하기 쉽도록 멤버변수로 배치
	static StringBuilder sb = new StringBuilder();		// StringBuilder를 이용해 한번에 출력하는 것이 시간 단축에 많이 도움이 됨

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		selected = new int[N];
		visited = new boolean[N];

		permutation(0);		// 0으로 최초 호출
		System.out.print(sb);		// StringBuilder에 저장된 값 출력
	}

	private static void permutation(int depth) {
		if(depth==N) {		// N번 호출되었으면
			for(int i=0; i<N; i++) {		// selected에 저장된 값을 StringBuilder에 저장
				sb.append(selected[i]).append(" ");
			}
			sb.append('\n');		// 줄바꿈도 저장
			return;
		}

		for(int i=0; i<N; i++) {		// 순열은 첫 인덱스부터 다시 돌아야 함
			if(visited[i])		// 중복은 허용하지 않으므로 방문체크
				continue;

			selected[depth] = i+1;		// 인덱스는 실제 숫자보다 하나 작으므로 +1
			visited[i] = true;		// 같은 수를 방문하지 못하도록 체크
			permutation(depth+1);		// 다음 depth 재귀 호출
			visited[i] = false;		// 재귀가 끝났으면 숫자를 다시 선택할 수 있도록 방문체크 해제
		}
	}
}