package 백준.골드5.CCW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] x = new int[3];
        int[] y = new int[3];
        for(int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int ccw = 0;
        for(int i=0; i<3; i++)
            ccw += x[i] * y[(i+1)%3];
        for(int i=0; i<3; i++)
            ccw -= y[i] * x[(i+1)%3];

        System.out.println(Integer.compare(ccw, 0));
    }
}