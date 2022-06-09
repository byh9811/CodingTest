package 프로그래머스.레벨2.괄호_회전하기;

import java.util.Stack;

public class Solution {
    public int solution(String s) {
        int answer = 0;

        for(int i=0; i<s.length()-1; i++) {
            if(isRight(s.substring(i)+s.substring(0, i)))
                answer++;
        }

        return answer;
    }

    private boolean isRight(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()) {
            switch (c) {
                case '(': case '[': case '{': stack.add(c); break;
                default: {
                    if(stack.isEmpty())
                        return false;

                    char rightChar;

                    switch (c) {
                        case ')': rightChar = '('; break;
                        case ']': rightChar = '['; break;
                        default: rightChar = '{';
                    }

                    if(rightChar!=stack.pop())
                        return false;
                }
            }
        }

        return stack.isEmpty() ? true : false;
    }
}