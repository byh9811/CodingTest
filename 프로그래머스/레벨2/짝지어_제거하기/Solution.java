package 프로그래머스.레벨2.짝지어_제거하기;

import java.util.Stack;

public class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);

            if(!stack.isEmpty() && stack.peek()==cur)
                stack.pop();
            else
                stack.add(cur);
        }

        if(stack.isEmpty())
            return 1;
        else
            return 0;
    }
}