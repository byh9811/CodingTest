package 백준.골드2.빵집;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 빵집
 * https://www.acmicpc.net/problem/3109
 *
 * 1. 반드시 다음 열로 움직여야 하며, 행은 한칸 위/유지/한칸 아래로 움직일 수 있다.
 * 2. 모든 열에 대해 파이프라인 건설을 시도하되, 막히면 포기한다.
 * 3. 위쪽부터 사용할 수 있는 공간을 가능한 한 사용해서 아래쪽 공간이 최대한 남기도록 한다.
 * 4. 반복문을 사용하여 행을, 재귀를 사용하여 열을 이동한다.
 * 5. 핵심은 한번 실패했던 루트를 다시 갈 필요가 없다는 아이디어이다.
 * 
 * @author 배용현
 *
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int R, C, answer = 0;
	static boolean arrived;
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = parseInt(st.nextToken());
		C = parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String input = br.readLine(); 
			for(int j=0; j<C; j++)
				map[i][j] = input.charAt(j);
		}
		
		for(int i=0; i<R; i++) {
			arrived = false;		// 현재 행에서 출발한 파이프의 도착 여부 초기화
			dfs(i, 0);		// 파이프 건설 설계 재귀 호출
		}
		
		System.out.print(answer);
	}

	private static void dfs(int row, int col) {		// 파이프 경로를 설정하는 dfs
		if(col==C-1) {		// 파이프 경로 설정이 완료되면
			arrived = true;		// 현재 행의 파이프 설계 완료 표시
			answer++;		// 파이프 만들수 있는 개수 +1
			return;
		}

		for(int j=row-1; j<=row+1; j++) {		// 위, 옆, 아래 3방향
			if(arrived || j<0 || j>R-1 || map[j][col+1]=='x')		// 같은 행으로 시작한 파이프 건설이 완료되었거나
				continue;		// 갈 수 없는 곳이면 패스
			
			map[j][col+1] = 'x';		// 지나온 길은 x로 바꿔서 다시 못오게 함
			dfs(j, col+1);		// 다음 열 어디에 파이프 설치할지 재귀 호출
			// 실패했던 루트는 어떤 방법으로 다시 가더라도 실패하게되므로 복원 안함
		}
	}
}