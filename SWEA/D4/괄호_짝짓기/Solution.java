package SWEA.D4.괄호_짝짓기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 괄호 짝짓기
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD
 *
 * 1. 스택을 이용하여 여는 괄호를 저장한다.
 * 2. 닫는 괄호가 입력되면 종류가 맞는 여는 괄호를 스택에서 pop하고 진행한다.
 * 3. 스택이 비어있을 경우, 스택에서 pop한 괄호의 종류가 다른 경우, 마지막에 스택에 괄호가 남아있는 경우 0을 리턴한다.
 * 4. 전체적으로 한 번씩 접근하면 되기 때문에 O(N)의 시간복잡도를 가진다.
 *
 * @author 배용현
 *
 */
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {		// 테스트 케이스는 10개
			int N = Integer.parseInt(br.readLine());		// 사실상 필요없는데 예의상 씀
			String input = br.readLine();		// 문자열 정보
			System.out.printf("#%d %d\n", t, isRight(N, input));		// 올바른 문자열이면 1, 아니면 0 출력
		}
	}

	private static int isRight(int N, String input) {		// 올바른 문자열이면 1, 아니면 0 반환
		Stack<Character> stack = new Stack<>();		// 올바른 짝인지 찾기 위한 stack
		for(int i=0; i<N; i++) {		// 문자열 순회하면서
			char c = input.charAt(i);		// 현재 문자가
			if(isOpen(c)) {		// 열린 괄호면
				stack.add(c);		// 스택에 push
			} else {		// 닫힌 괄호면
				if(stack.isEmpty() || !isSameKind(stack.pop(), c))		// 스택에서 pop하는데 스택이 비어있거나 괄호의 종류가 다르면
					return 0;		// 올바른 문자열이 아님
			}
		}

		return stack.isEmpty() ? 1 : 0;		// 아직 처리되지 못한 열린 괄호가 남아있으면 올바른 문자열이 아님
	}

	private static boolean isSameKind(char open, char close) {		// 두 괄호가 같은 종류인지 판별하는 메서드
		if((open=='(' && close==')') || (open=='[' && close==']') ||
				(open=='<' && close=='>') || (open=='{' && close=='}'))		// 같은 종류면
			return true;		// true 반환
		return false;		// 다른 종류면 false 반환
	}

	private static boolean isOpen(char c) {		// 여는 괄호임을 확인하는 메서드
		if(c=='(' || c=='[' || c=='{' || c=='<')		// 여는 괄호면
			return true;		// true 리턴
		return false;		// 아니면 false 리턴
	}
}
