package 백준.실버4.요세푸스_문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * 요세푸스 문제
 * https://www.acmicpc.net/problem/1158
 * 
 * 1. 순서대로 접근하여 삭제하는 연산이 반복되므로 LinkedList가 적합하다.
 * 2. list에 원소들을 넣고 idx를 따로 관리하면서 다음에 제거되는 인덱스를 계산한다.
 * 3. 공식은 (idx-1+k)%size 이다.
 * 4. 마지막 원소의 뒤에 붙는 구분자는 제거해야 한다.
 * 
 * @author 배용현
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());		// 사람의 수
		int K = parseInt(st.nextToken());		// 제거될 순번
		
		LinkedList<Integer> list = new LinkedList<>();		// 사람이 앉은 list
		for(int i=1; i<=N; i++)		// 사람 추가
			list.add(i);

		int idx = 0;		// 제거될 인덱스
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		while(!list.isEmpty()) {		// 리스트가 빌 때까지
			idx = (idx-1+K)%list.size();		// idx 수정
			sb.append(list.remove(idx)).append(", ");		// idx의 원소 제거 및 sb에 추가
		}
		
		sb.setLength(sb.length()-2);		// 마지막  구분자 제거
		sb.append('>');
		System.out.println(sb);
	}
}
