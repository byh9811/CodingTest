package SWEA.D4.사칙연산_유효성검사;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 사칙연산 유효성 검사
 * https://swexpertacademy.com/main/code/problem/problemSolver.do?contestProbId=AV141176AIwCFAYD
 * 
 * 1. 입력이 4개면 자식이 있는 노드이기 때문에 연산자를 값으로 가져야 함.
 * 2. 입력이 2개면 자식이 없는 노드이기 때문에 피연산자를 값으로 가져야 함.
 * 3. 이를 이용해 따로 자료구조 사용 없이 입력처리만으로 풀 수 있다.
 * 
 * @author 배용현
 *
 */
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {		// tc 10개 고정
			int N = Integer.parseInt(br.readLine());
			boolean isRight = true;		// 올바른 트리인지 저장할 변수
			
			for(int i=0; i<N; i++) {		// N줄의 입력
				String[] input = br.readLine().split(" ");		// 입력의 개수를 얻기 위해 split 사용
				
				if(!isRight)		// 이미 잘못된 트리이면 시간 절약
					continue;
				
				if(input.length==4 && !isOperator(input[1].charAt(0)) || 
						input.length==2 && isOperator(input[1].charAt(0)))
					isRight = false;		// 부모 노드이면 연산자, 리프 노드이면 피연산자를 가져야함. 아니면 false
			}

			sb.append('#').append(tc).append(' ').append(isRight ? 1 : 0).append('\n');		// 형식에 맞게 출력 저장
		}
		
		System.out.println(sb);
	}

	private static boolean isOperator(char value) {		// 해당 문자가 연산자인지 확인하는 메서드
		switch(value) {		// 연산자면 true, 피연산자면 false
		case '+': case '-': case '*': case '/': return true;
		default: return false;
		}
	}
}