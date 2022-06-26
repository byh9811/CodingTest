package 프로그래머스.레벨2.쿼드압축_후_개수_세기;

public class Solution {
    int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        dp(0, 0, arr.length, arr);

        return answer;
    }

    private void dp(int x, int y, int len, int[][] arr) {
        if(isCompressible(x, y, len, arr)) {
            answer[arr[y][x]]++;
            return;
        }

        int unit = len/2;
        dp(x, y, unit, arr);
        dp(x+unit, y, unit, arr);
        dp(x, y+unit, unit, arr);
        dp(x+unit, y+unit, unit, arr);
    }

    private boolean isCompressible(int x, int y, int len, int[][] arr) {
        for(int i=y; i<y+len; i++) {
            for(int j=x; j<x+len; j++) {
                if(arr[y][x]!=arr[i][j])
                    return false;
            }
        }

        return true;
    }
}