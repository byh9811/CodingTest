package 프로그래머스.레벨2.올바른_괄호;

import java.util.Stack;

public class Solution {
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()) {
            if(c=='(')
                stack.push('(');
            else {
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
        }

        return stack.isEmpty() ? true : false;
    }
}