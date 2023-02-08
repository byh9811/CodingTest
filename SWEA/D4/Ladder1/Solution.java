package SWEA.D4.Ladder1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * Ladder1
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh
 * 
 * 1. 도착 지점이 어디로 주어졌는지 구한다.
 * 2. 도착 지점에서 시작하여 출발지점에 도달했을 때, 해당 위치가 어디인지 구한다.
 * 3. n이 최대 100인데, dfs를 사용하므로 O(n^2)의 시간복잡도로 약 10,000번 연산으로 통과할 수 있다.
 * 
 * @author 배용현
 *
 */
public class Solution {
	static int[] dx = {0,0,-1};		// 방향을 찾기 위한 변수
	static int[] dy = {-1,1,0};		// 방향을 찾기 위한 변수
	static int[][] map;		// 지도 저장을 위한 변수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case=1; test_case<=10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			map = new int[100][100];		// 새로운 변수로 선언
			int des = 0;		// 목적지 좌표를 저장하기 위한 변수
			for(int i = 0; i< 100; i++) {		// for input
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j< 100; j++)
					map[i][j] = Integer.parseInt(st.nextToken()); // 지도에 값 넣기
			}
			for(int j=0; j<100; j++) {
				if(map[99][j]==2) {
					des = j; // 목적지 좌표를 des에 넣어준다.
					break;
				}
			}
			System.out.println("#" + t + " " + ladder(98, des));
		}
	}
	
	private static int ladder(int a, int b) {		// dfs를 위한 함수
		if(a==0) {		// 종료조건 : map[a][b]중 a가 0에 도달하면 출발지에 도착한 것이므로
			return b;		// b를 return 하여 좌표 return
		}
		
		for(int i=0; i<3; i++) {		// 아래로는 갈 수 없으니 3개 반복
			int nx = a + dx[i];		// 좌표 이동
			int ny = b + dy[i];		// 좌표 이동
			if(0<=nx && nx<100 && 0<=ny && ny<100 && map[nx][ny]==1) {		// 범위 내에 있고, 사다리 내면
				map[nx][ny] = 0;		// 다시 방문하지 않기위해 0으로 설정
				return ladder(nx, ny);		// 재귀 호출
			}
		}
		
		return -1;
	}

}
