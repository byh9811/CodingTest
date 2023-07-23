package 프로그래머스.레벨2.연속된_부분_수열의_합;

import java.util.*;

/*
1. sequence의 길이가 최대 1,000,000이므로 NlogN이하의 알고리즘을 사용해야 한다.
2. 수열은 반드시 두 인덱스 사이의 연속된 원소로 이루어져야 한다.
3. 투 포인터를 이용하여 수열을 확인하고, k와의 차이를 확인하면서 진행하면 O(N)으로 풀이 가능하다.
4. 수열의 합과 k와의 차가 0이거나 양수이면 비교 후 앞 포인터를 증가시킨다.
5. 수열의 합과 k와의 차가 음수이면 비교 후 뒷 포인터를 증가시킨다.
6. 3번째 조건을 만족하기 위해서는 나중 경우를 채택해야 하는데, 4번째 조건을 만족하기 위해서는 먼저 경우를 생각해야 한다.

- 풀이 시간: 36분 46초

*/
class Solution {
    public int[] solution(int[] sequence, int k) {
        int head = 0;
        int tail = 0;
        int sum = sequence[0];
        int minLength = Integer.MAX_VALUE;
        int answerHead = head;
        int answerTail = tail;
        
        while(tail<sequence.length) {
            if(sum==k && minLength>tail-head) {     // 부분합이 k이고 최단 길이를 갱신했으면 정답 갱신
                answerHead = head;
                answerTail = tail;
                minLength = tail - head;
            }
            
            if(sum>=k) {        // sum-k가 0이거나 양수일 때
                sum -= sequence[head];
                head++;
            } else {        // 음수일 때
                tail++;
                if(tail==sequence.length) {
                    break;
                }
                sum += sequence[tail];
            }
            
        }
        
        return new int[]{answerHead, answerTail};
    }
}