package 프로그래머스.코딩테스트_고득점_Kit.DFS_및_BFS.단어_변환;

public class Solution {
    boolean[] visited;
    String target;
    String[] words;
    int length;
    int min = Integer.MAX_VALUE;
    boolean found = false;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        this.target = target;
        this.words = words;
        length = words[0].length();

        dfs(begin, 0);

        return found ? min : 0;
    }

    private void dfs(String cur, int level) {
        if(level>=min)
            return;

        if(cur.equals(target)) {
            min = Math.min(min, level);
            found = true;
            return;
        }

        for(int i=0; i<words.length; i++) {
            if(!visited[i] && convert(cur, words[i])) {
                visited[i] = true;
                dfs(words[i], level+1);
                visited[i] = false;
            }
        }
    }

    private boolean convert(String source, String destination) {
        int numEqual = 0;
        for(int i=0; i<source.length(); i++) {
            if(source.charAt(i)==destination.charAt(i))
                numEqual++;
        }
        return numEqual>=length-1 ? true : false;
    }
}