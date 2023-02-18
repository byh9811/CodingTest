package 백준.골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 배열 돌리기 4
 * https://www.acmicpc.net/problem/17406
 *
 * 1. 배열을 회전시키는 메서드를 구현한다.
 * 2. 회전 연산을 순열로 만든다.
 * 3. 만든 순서대로 회전하고 배열의 각 행별 합을 구한다.
 * 4. 각 행별 합의 최솟값을 저장하고 출력한다.
 *
 * @author 배용현
 */
public class Main {
	static int N, M, K, answer = Integer.MAX_VALUE;
	static int[][] cmd, map, mapOrigin;
	static int[] selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());		// 행 수 N
		M = Integer.parseInt(st.nextToken());		// 열 수 M
		K = Integer.parseInt(st.nextToken());		// 연산 수 K

		map = new int[N][M];		// 연산에 사용할 map
		mapOrigin = new int[N][M];		// 원본 데이터를 저장할 map
		selected = new int[K];		// 선택된 연산의 순서
		cmd = new int[K][3];		// 연산의 정보
		
		for(int i=0; i<N; i++) {		// 맵 정보 입력
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
				mapOrigin[i][j] = Integer.parseInt(st.nextToken());
		}

		for(int i=0; i<K; i++) {		// 연산 정보 입력
			st = new StringTokenizer(br.readLine());

			cmd[i][0] = Integer.parseInt(st.nextToken()) - 1;		// 행 값은 인덱스로 보기 위해 -1
			cmd[i][1] = Integer.parseInt(st.nextToken()) - 1;		// 열 값도 인덱스로 보기 위해 -1
			cmd[i][2] = Integer.parseInt(st.nextToken());
		}

		permutation(0, 0);

		System.out.println(answer);
	}

	private static void permutation(int depth, int flag) {		// 연산을 순서대로 배치하기 위한 순열 재귀
		if(depth==K) {		// K개 뽑았으면
			for(int i=0; i<mapOrigin.length; i++)		// 회전에 사용할 배열 데이터 복원
				map[i] = Arrays.copyOf(mapOrigin[i], mapOrigin[i].length);

			for(int i=0; i<K; i++)		// 선택한 연산 순서대로 배열 회전
				rotate(cmd[selected[i]]);

			answer = Math.min(answer, getMinRowSum());		// 회전시킨 배열 행의 합 중 작은 값 저장
			return;
		}

		for(int i=0; i<K; i++) {		// 순열은 처음부터 원소 수까지
			if((flag&(1<<i))!=0)		// 비트마스킹을 이용한 방문체크
				continue;

			selected[depth] = i;		// 연산 순서 선택
			permutation(depth+1, flag|(1<<i));		// 해당 연산을 마스킹한뒤 다음 재귀 호출
		}
	}

	private static void rotate(int[] cmd) {		// 배열을 회전시키는 메서드
		int r = cmd[0];		// 연산의 타겟 중앙 행
		int c = cmd[1];		// 연산의 타겟 중앙 열
		int s = cmd[2];		// 연산의 타겟 길이

		int[][] copyMap = new int[N][M];		// 회전 결과를 저장하기 위해 2차원 배열 새로 생성
		for(int i=0; i<map.length; i++)
			copyMap[i] = Arrays.copyOf(map[i], map[i].length);

		for(int i=1; i<=s; i++) {
			int temp = copyMap[r-i][c-i];
			for(int j=r-i; j<r+i; j++)		// 위로 이동 (왼쪽 열)
				copyMap[j][c-i] = copyMap[j+1][c-i];

			for(int j=c-i; j<c+i; j++)		// 왼쪽으로 이동 (아래쪽 행)
				copyMap[r+i][j] = copyMap[r+i][j+1];

			for(int j=r+i; j>r-i; j--)		// 아래로 이동 (오른쪽 열)
				copyMap[j][c+i] = copyMap[j-1][c+i];

			for(int j=c+i; j>c-i; j--)		// 왼쪽으로 이동 (위쪽 행)
				copyMap[r-i][j] = copyMap[r-i][j-1];

			copyMap[r-i][c-i+1] = temp;		// 늦게 이동하여 묻힌 첫 데이터 복구
		}

		map = copyMap;		// 새로 만든 맵을 가리키도록 교체
	}

	private static int getMinRowSum() {		// 행 값의 합 더한 뒤 가장 작은 값을 리턴하는 메서드
		int minRowSum = Integer.MAX_VALUE;		// 행 최소값

		for(int i=0; i<N; i++) {
			int rowSum = 0;				// 현재 행의 합

			for(int j=0; j<M; j++)			// 열 순회하면서
				rowSum += map[i][j];		// 현재 행 값 더함

			minRowSum = Math.min(minRowSum, rowSum);		// 최소 행값 저장
		}

		return minRowSum;		// 최소 행값 리턴
	}
}
