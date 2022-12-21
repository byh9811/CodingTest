package 프로그래머스.레벨1.햄버거_만들기;

import java.util.Stack;

public class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int elem: ingredient) {
            if(elem==1 && canMake(stack)) {
                answer++;
            } else {
                stack.add(elem);
            }
        }

        return answer;
    }

    private boolean canMake(Stack<Integer> stack) {
        if(stack.size()<3)
            return false;

        int top = stack.pop();
        int mid = stack.pop();
        int bot = stack.pop();

        if(top==3 && mid==2 && bot==1)
            return true;

        stack.add(bot);
        stack.add(mid);
        stack.add(top);
        return false;
    }
}