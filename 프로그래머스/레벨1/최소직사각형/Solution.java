package 프로그래머스.레벨1.최소직사각형;

public class Solution {
    public int solution(int[][] sizes) {
        int height = 0;
        int width = 0;

        for(int[] size: sizes) {
            int big = Math.max(size[0], size[1]);
            int small = Math.min(size[0], size[1]);
            height = Math.max(height, big);
            width = Math.max(width, small);
        }

        return height*width;
    }
}