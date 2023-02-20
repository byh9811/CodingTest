package 백준.실버2.색종이만들기;

import java.util.Scanner;

/**
 * 색종이 만들기
 * https://www.acmicpc.net/problem/2630
 * 
 * 1. 사분면으로 나누고 하나씩 순서대로 접근한다.
 * 2. 사분면의 파란색 종이 개수를 계산한다.
 * 3. 파란색으로만 이루어진 경우 파란종이를 사분면 크기만큼 더하고, 반대의 경우도 마찬가지로 처리한다.
 * 4. 두 색상이 혼합된 경우 다음 대귀를 호출하여 1~3을 반복한다.
 * 
 * @author 배용현
 *
 */
public class Main {
	static int white = 0;		// 하얀색 종이의 수
	static int blue = 0;		// 파란색 종이의 수
	static int[][] map;		// 전체 종이의 정보

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				map[i][j] = sc.nextInt();
		}

		cut(0, 0, n);		// 첫 행, 첫 열 기준 size와 함께 시작

		System.out.println(white);
		System.out.println(blue);
		sc.close();
	}

	static void cut(int r, int c, int size) {		// Divide And Conquer 재귀 메서드
		int sum = 0;

		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++)
				sum += map[i][j];
		}

		if(sum==size*size) {		// 모두 파란색
			blue++;
		} else if(sum==0) {		// 모두 하얀색
			white++;
		} else {		// 혼합된 상황
			int half = size/2;		// size는 반으로 줄어야 한다.
			cut(r, c, half);		// 1 사분면
			cut(r, c+half, half);		// 2 사분면
			cut(r+half, c, half);		// 3 사분면
			cut(r+half, c+half, half);		// 4 사분면
		}
	}
}