package 프로그래머스.레벨2.땅따먹기;

public class Solution {
    public int solution(int[][] land) {
        for(int i=1; i<land.length; i++) {
            for(int j=0; j<4; j++)
                land[i][j] += getMax(land[i-1], j);
        }

        return getMax(land[land.length-1], 4);
    }

    private int getMax(int[] land, int j) {
        int max = 0;

        for(int i=0; i<4; i++) {
            if(i!=j && max<land[i])
                max = land[i];
        }

        return max;
    }
}