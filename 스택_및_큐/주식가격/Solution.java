package 스택_및_큐.주식가격;

import java.util.Stack;

public class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> valStk = new Stack<>();
        Stack<Integer> idxStk = new Stack<>();
        valStk.add(0);
        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length; i++) {
            while(true) {
                if(valStk.peek()<=prices[i])
                    break;
                valStk.pop();
                int idx = idxStk.pop();
                int period = i-idx;
                answer[idx] = period;
            }

            valStk.add(prices[i]);
            idxStk.add(i);
        }

        for(int idx: idxStk) {
            int period = prices.length - (idx+1);
            answer[idx] = period;
        }

        return answer;
    }
}