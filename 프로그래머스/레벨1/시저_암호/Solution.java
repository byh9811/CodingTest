package 프로그래머스.레벨1.시저_암호;

public class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray())
            sb.append(encode(c, n));

        return sb.toString();
    }

    private char encode(char c, int n) {
        char ret = (char)(c+n);
        if(c==' ')
            return c;
        else if(c>='A' && c<='Z')
            return ret>'Z' ? (char)(ret-26) : ret;
        else
            return ret>'z' ? (char)(ret-26) : ret;
    }
}