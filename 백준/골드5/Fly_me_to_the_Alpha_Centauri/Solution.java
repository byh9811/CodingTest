package 백준.골드5.Fly_me_to_the_Alpha_Centauri;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            int distance = y - x;
            int maxSpeed = (int)Math.sqrt(distance);

            if(maxSpeed==Math.sqrt(distance))
                System.out.println(maxSpeed*2-1);
            else if(distance<=maxSpeed*maxSpeed+maxSpeed)
                System.out.println(maxSpeed*2);
            else
                System.out.println(maxSpeed*2+1);
        }
    }
}