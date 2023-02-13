package 백준.골드5.탑;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 탑
 * https://www.acmicpc.net/problem/1158
 * 
 * 1. N이 최대 500,000이므로 2중반복문으로 모두 비교하면 시간 초과가 발생한다.
 * 2. 배열의 원소를 역순으로 접근하면서 인덱스를 스택에 넣는다.
 * 3. 현재 인덱스의 값이 스택의 값보다 클때까지 뽑고 정답배열에 현재 인덱스를 넣는다.
 * 4. 배열의 원소를 N+1개로 생성하면 편할 것 같다.
 * 
 * @author 배용현
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());		// 탑 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];		// 탑 높이 정보
		for(int i=1; i<=N; i++)		// 탑 높이 정보 입력 처리
			arr[i] = parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[N+1];		// 레이저가 도달하는 탑의 인덱스
		for(int i=answer.length-1; i>=1; i--) {		// 거꾸로 접근하면서
			while(!stack.isEmpty() && arr[i]>=arr[stack.peek()])		// 스택에 원소가 존재하고 현재 원소가 스택에 저장된 원소보다 크면(레이저를 받을 수 있으면)
				answer[stack.pop()] = i;		// answer에 현재 인덱스 저장
			
			stack.add(i);		// 처리한 뒤 이 탑도 레이저를 쏘므로 스택에 저장
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++)		// 저장된 인덱스 출력. 저장되지 않은 값은 자동으로 0으로 출력된다.
			sb.append(answer[i]).append(' ');
		System.out.println(sb);
	}
}
