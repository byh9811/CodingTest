package 백준.실버5.재귀_함수가_뭔가요;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 재귀 함수가 뭔가요?
 * https://www.acmicpc.net/problem/17478
 *
 * 1. StringBuilder를 이용해 문자열 연산을 빠르게 수행한다.
 * 2. "재귀함수가 뭔가요?"는 호출과 동시에 넣어준다.
 * 3. "잘 들어보게.~"는 재귀의 끝에 도달하지 않았을 경우 넣어준다.
 * 4. 재귀의 끝에 도달하면 "재귀함수는 자기 자신을 호출하는 함수라네"를 넣어준다.
 * 5. 재귀가 종료되기 전에는 "라고 답변하였지."를 넣어준다.
 * 6. 각 호출 스택에 맞게 앞에 언더바를 붙이는 메서드를 만들어 수행한다.
 *
 * @author 배용현
 */
public class Main {
	public static StringBuilder sb = new StringBuilder();		// 빠른 출력용 StringBuilder
	public static int n;		// 재귀 함수에서 입력값을 편하게 접근하기 위해 멤버변수로 선언
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	
    	sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");		// 시작 멘트
    	recur(0);		// 스택은 0부터 시작
    	System.out.println(sb);			// 넣어준 문자열 출력
    }
    
    public static void recur(int stack) {		// 재귀 호출
    	indentation(stack);
    	sb.append("\"재귀함수가 뭔가요?\"\n");		// 호출과 동시에
    	
    	if(stack==n) {		// 재귀의 끝에 도달
        	indentation(stack);
    		sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");

        	indentation(stack);
        	sb.append("라고 답변하였지.\n");
        	
    		return;
    	}

    	indentation(stack);
    	sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");		// 재귀의 끝에 도달하지 않았을 경우

    	indentation(stack);
    	sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");		// 재귀의 끝에 도달하지 않았을 경우

    	indentation(stack);
    	sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");		// 재귀의 끝에 도달하지 않았을 경우
    	
    	recur(stack+1);		// 스택을 증가시키고 재귀 호출

    	indentation(stack);
    	sb.append("라고 답변하였지.\n");		// 재귀가 종료되기 전
    }
    
    public static void indentation(int stack) {		// 호출 스택에 따라 언더바를 붙여주는 메서드
    	for(int i=0; i<stack; i++)		// 스택이 1증가할 때마다
    		sb.append("____");		// 4개씩 추가로 반복
    }
}