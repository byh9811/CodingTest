package 백준.골드5.컨베이어_벨트_위의_로봇;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    int N, K, brokenBelt = 0;
    int[] belt;
    boolean[] hasRobot;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[N*2];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<belt.length; i++)
            belt[i] = Integer.parseInt(st.nextToken());
        hasRobot = new boolean[N];
        int answer = 1;
        while(true) {
            rotateBelt();
            moveRobot();
            putRobot();
            if(brokenBelt>=K)
                break;
            answer++;
        }
        System.out.println(answer);
    }

    private void putRobot() {
        if(belt[0]>0) {
            hasRobot[0] = true;
            if(--belt[0]==0)
                brokenBelt++;
        }
    }

    private void moveRobot() {
        for(int i=N-1; i>0; i--) {
            if(hasRobot[i-1] && !hasRobot[i] && belt[i]>0) {
                hasRobot[i] = true;
                hasRobot[i-1] = false;
                if(--belt[i]==0)
                    brokenBelt++;
            }
        }
        hasRobot[hasRobot.length-1] = false;
    }

    private void rotateBelt() {
        int temp = belt[belt.length-1];
        for(int i=belt.length-1; i>0; i--)
            belt[i] = belt[i-1];
        for(int i=N-2; i>=0; i--) {
            if(!hasRobot[i])
                continue;
            hasRobot[i+1] = true;
            hasRobot[i] = false;
        }
        belt[0] = temp;
        hasRobot[hasRobot.length-1] = false;
    }
}