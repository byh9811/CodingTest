package SWEA.D3.암호문1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * 암호문 1
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14w-rKAHACFAYD
 * 
 * 1. 특정 위치에 값을 넣는 연산이 반복되고 조회 연산이 거의 사용되지 않으므로 LinkedList 자료구조를 사용한다.
 * 2. 숫자를 입력할 때 입력할 인덱스도 함께 증가시켜 순서대로 넣을 수 있도록 한다.
 * 
 * @author 배용현
 *
 */
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int test_case=1; test_case<=10; test_case++) {		// tc 10개
			int N = parseInt(br.readLine());		// 원본 암호문의 길이
			StringTokenizer st = new StringTokenizer(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();		// LinkedList 생성
			for(int i=0; i<N; i++)		// 원본 암호문 list에 저장
				list.add(parseInt(st.nextToken()));
			
			N = parseInt(br.readLine());		// 명령어의 개수
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {		// 명령어 처리
				if(st.nextToken().equals("I")) {		// 명령어가 존재할 경우 시작은 I
					int idx = parseInt(st.nextToken());		// 처음에 오는 숫자는 넣을 인덱스
					int num = parseInt(st.nextToken());		// 두번째로 오는 숫자는 덧붙일 숫자의 개수
					
					for(int i=0; i<num; i++)		// 덧붙일 숫자를 idx에 순차적으로 저장
						list.add(idx++, parseInt(st.nextToken()));		// idx를 함께 증가시켜줘야 순서대로 들어감
				}
			}
			
			sb.append('#').append(test_case).append(' ');		// 테스트케이스 초기 문자열
			for(int i=0; i<10; i++)		// 처음 10개의 항만 출력
				sb.append(list.get(i)).append(' ');		// 암호 문자열 10개
			sb.append('\n');		// tc 줄바꿈
		}
		System.out.print(sb);		// 출력
	}
}
