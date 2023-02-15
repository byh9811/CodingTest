package 백준.실버1.절댓값_힙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

import static java.lang.Integer.parseInt;

/**
 * 절댓값 힙
 * https://www.acmicpc.net/problem/11286
 * 
 * 1. 절댓값을 만들어서 넣으면 꺼냈을때 값이 무엇인지 알 수 없다.
 * 2. 따라서 값을 그대로 넣되 음수는 최대힙에, 양수는 최소힙에 넣는다.
 * 3. 양쪽 peek의 절댓값을 비교하여 작은 쪽을 출력하고, 제거한다.
 * 4. N만큼 출력하고, 힙이 비어있는데 출력하라고 하면 0을 출력한다.
 * 
 * @author 배용현
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = parseInt(br.readLine());
		PriorityQueue<Integer> plusHeap = new PriorityQueue<>();		// 양수가 저장되는 최소힙
		PriorityQueue<Integer> minusHeap = new PriorityQueue<>(Collections.reverseOrder());		// 음수가 저장되는 최대힙
		
		for(int i=0; i<N; i++) {
			int input = parseInt(br.readLine());
			if(input==0) {		// 입력이 0이면 출력
				if(minusHeap.isEmpty() && plusHeap.isEmpty())		// 둘다 비어있으면 0 출력
					sb.append(0);
				else if(minusHeap.isEmpty())		// 한쪽 힙만 비어있으면 반대쪽에서 뽑아서 출력
					sb.append(plusHeap.poll());
				else if(plusHeap.isEmpty())		// 한쪽 힙만 비어있으면 반대쪽에서 뽑아서 출력
					sb.append(minusHeap.poll());
				else		// 더해서 절댓값이 작은쪽 출력, 같다면 음수 출력
					sb.append(minusHeap.peek()+plusHeap.peek()>=0 ? minusHeap.poll() : plusHeap.poll());
				
				sb.append('\n');
			} else if(input>0) {		// 입력이 양수면 최소힙에 저장
				plusHeap.add(input);
			} else {		// 입력이 음수면 최대힙에 저장
				minusHeap.add(input);
			}
		}
		
		System.out.println(sb);
	}
}
