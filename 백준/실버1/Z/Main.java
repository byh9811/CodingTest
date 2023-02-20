package 백준.실버1.Z;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Z
 * https://www.acmicpc.net/problem/1074
 * 
 * 1. 사분면으로 나누고 하나씩 순서대로 접근한다.
 * 2. 행과 열 인덱스가 각각 현재 탐색중인 사분면의 마지막 인덱스보다 작으면 그 사분면에 존재한다는 의미이다.
 * 3. 존재한다면 다시 재귀를 호출하고, 존재하지 않는다면 크기만큼 정답에 더해준다.
 * 4. 다시 재귀를 호출할 때 행과 열은 끝위치를 기준으로 설정하고, 크기는 반으로 줄인다.
 * 
 * @author 배용현
 *
 */
public class Main {
	static int r, c;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());
		r = parseInt(st.nextToken());
		c = parseInt(st.nextToken());
		
		int initialLength = (int)Math.pow(2, N);		// 초기 변의 길이
		System.out.println(dac(initialLength-1, initialLength-1, initialLength/2));		// size는 한 사분면의 size
	}

	private static int dac(int endR, int endC, int size) {		// 분할정복 재귀 메서드
		if(size==0)		// 최종 찾는 위치로 접근했으면
			return 0;		// 뭐 더할 필요 없이 이곳의 번호 그대로 리턴
		
		int sum = 0;		// 지나온 번호 기록
		for(int i=endR-size; i<=endR; i+=size) {		// 아래행 아래열 기준 4분면 순회
			for(int j=endC-size; j<=endC; j+=size) {
				if(r>i || c>j)		// 현재 사분면에 없는 경우
					sum += size*size;		// 모든 원소가 정답 원소 이전에 있는 것이므로 사분면 넓이를 더해줌
				else		// 해당 사분면에 존재할 경우
					return sum + dac(i, j, size/2);		// 현재까지 누적한 원소 수 가지고 재귀 호출
			}
		}
		
		return -1;		// 사실상 호출되지 않음
	}

}