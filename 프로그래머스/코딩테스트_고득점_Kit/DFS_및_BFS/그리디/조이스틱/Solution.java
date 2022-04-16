package 프로그래머스.코딩테스트_고득점_Kit.DFS_및_BFS.그리디.조이스틱;

public class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int colMove = length - 1;
        for(int i=0; i<length; i++) {
            answer += name.charAt(i)<'N' ? name.charAt(i)-'A' : 'Z'-name.charAt(i)+1;
            int idx = i + 1;
            while(idx<length && name.charAt(idx)=='A')
                idx++;
            colMove = Math.min(colMove, i*2+length-idx);
            colMove = Math.min(colMove, (length-idx)*2+i);
        }
        return answer+colMove;
    }
}