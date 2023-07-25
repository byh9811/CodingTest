package 프로그래머스.레벨2.뒤에_있는_큰_수_찾기;

import java.util.*;

/*
1. 원소마다 뒷 원소를 모두 확인하면 O(n^2)으로 시간초과가 날 것이다.
2. 원소를 순회하며 현재 원소가 스택의 peek에 저장된 수 보다 크면 스택이 peek이 크거나 같아질 때까지 스택에서 뽑는다.
3. 정답 배열의 뽑은 원소에 해당하는 인덱스에 현재 원소를 저장한다.
4. 현재 원소를 스택에 넣어놓는다.
5. 원소는 -1로 초기화해야한다.

풀이 시간: 19분 46초
*/
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        for(int i=0; i<numbers.length; i++) {
            while(!stack.isEmpty() && numbers[i]>stack.peekLast()[1]) {
                answer[stack.pollLast()[0]] = numbers[i];
            }
            stack.addLast(new int[]{i, numbers[i]});
        }
        
        return answer;
    }
}