package 백준.실버5.숫자_카드;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);

        int mpd = A - B;
        int goal = V - A;
        int answer = goal / mpd;

        System.out.println(goal%mpd == 0 ? answer+1 : answer+2);
    }
}