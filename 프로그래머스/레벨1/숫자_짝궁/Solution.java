package 프로그래머스.레벨1.숫자_짝궁;

public class Solution {
    public String solution(String X, String Y) {
        int[] arrX = new int[10];
        int[] arrY = new int[10];
        StringBuilder sb = new StringBuilder();

        for(char c: X.toCharArray())
            arrX[c-'0']++;
        for(char c: Y.toCharArray())
            arrY[c-'0']++;

        boolean isZero = true;
        for(int i=9; i>=0; i--) {
            if(arrX[i]==0 || arrY[i]==0)
                continue;

            sb.append(String.valueOf(i).repeat(Math.min(arrX[i], arrY[i])));
            if(i!=0)
                isZero = false;
        }

        if(sb.length()==0)
            return "-1";
        if(isZero)
            return "0";
        else
            return sb.toString();
    }
}