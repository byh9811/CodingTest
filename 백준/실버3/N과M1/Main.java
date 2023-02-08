package 백준.실버3.N과M1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * N과 M
 * https://www.acmicpc.net/problem/15649
 * 
 * 1. N중에서 M을 뽑는 순열을 출력하면 되는 문제다.
 * 2. N과 M이 각각 8까지 입력되므로 재귀를 사용해서 O(n!)로 풀 수 있다.
 * 
 * @author 배용현
 *
 */
public class Main {
	static int n, m;		// 접근하기 쉽도록 멤버변수로 선언
	static boolean[] visited;		// 접근하기 쉽도록 멤버변수로 선언
	static BufferedWriter bw;		// 출력 빠르게 하기 위해 BufferedWriter 사용
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());		// n 초기화
		m = Integer.parseInt(st.nextToken());		// m 초기화
		visited = new boolean[n+1];		// 방문배열 사용하기 쉽게 초기화
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		permutation("",0);		// 문자열로 뽑은 순열을 저장하고, 정수로 재귀 스택 기록
		bw.flush();
	}
	
	private static void permutation(String str, int cnt) throws IOException {
		if (cnt == m) {		// 스택이 m이되면 전부 뽑은 것이므로 return;
			bw.write(str+"\n");		// 출력하고 리턴
			return;
		}
		
		for(int i=1; i<=n; i++) {		// 방문배열을 
			if(visited[i]) continue;	// 똑같은 숫자 고르면 안되므로 방문 체크
			visited[i] = true;
			permutation(str + i + " ", cnt+1);		// 선택된 숫자 문자열에 추가하여 재귀호출
			visited[i] = false;
		}
	}
}
