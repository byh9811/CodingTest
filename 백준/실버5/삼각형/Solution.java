package 백준.실버5.삼각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] pointX = new int[3];
        int[] pointY = new int[3];
        int[] length = new int[3];

        for(int i=0; i<3; i++) {
            String[] input = br.readLine().split(" ");
            pointX[i] = Integer.parseInt(input[0]);
            pointY[i] = Integer.parseInt(input[1]);
        }
        length[0] = (int)(Math.pow(pointX[0]-pointX[1], 2) + Math.pow(pointY[0]-pointY[1], 2));
        length[1] = (int)(Math.pow(pointX[1]-pointX[2], 2) + Math.pow(pointY[1]-pointY[2], 2));
        length[2] = (int)(Math.pow(pointX[2]-pointX[0], 2) + Math.pow(pointY[2]-pointY[0], 2));
        Arrays.sort(length);

        String answer = "";
        int numberSameLength = getNumberSameLength(length);
        if(areOnStraight(pointX, pointY))
            answer = "X";
        else if(numberSameLength==3)
            answer = "JungTriangle";
        else if(numberSameLength==2)
            answer = getWidestKindOfAngle(length) + "2Triangle";
        else
            answer = getWidestKindOfAngle(length) + "Triangle";

        System.out.println(answer);
    }

    private String getWidestKindOfAngle(int[] length) {
        int ret = length[2]-(length[0]+length[1]);

        if(ret==0)
            return "Jikkak";
        else if(ret>0)
            return "Dunkak";
        else
            return "Yeahkak";
    }

    private boolean areOnStraight(int[] pointX, int[] pointY) {
        int dx01 = pointX[0]-pointX[1];
        int dy01 = pointY[0]-pointY[1];
        int dx02 = pointX[0]-pointX[2];
        int dy02 = pointY[0]-pointY[2];

        return dx01*dy02==dy01*dx02 ? true : false;
    }

    private int getNumberSameLength(int[] length) {
        if(length[0]==length[1] && length[1]==length[2])
            return 3;
        else if(length[0]!=length[1] && length[1]!=length[2])
            return 1;
        else
            return 2;
    }
}