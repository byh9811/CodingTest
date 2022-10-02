package 백준.실버5.DNA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        String[] dna = new String[N];
        int answerIdx = 0;
        int minHD = Integer.MAX_VALUE;

        for(int i=0; i<N; i++)
            dna[i] = br.readLine();
        Arrays.sort(dna);

        for(int i=0; i<N; i++) {
            int score = 0;

            for(int j=0; j<N; j++) {
                if(i==j)
                    continue;

                for(int k=0; k<M; k++) {
                    if(dna[i].charAt(k)!=dna[j].charAt(k))
                        score++;
                }
            }

            if(score<minHD) {
                minHD = score;
                answerIdx = i;
            }
        }

        System.out.println(dna[answerIdx] + "\n" + minHD);
    }
}