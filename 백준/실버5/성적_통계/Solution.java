package 백준.실버5.성적_통계;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=K; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] scores = new int[input[0]];
            for(int j=0; j<input.length-1; j++)
                scores[j] = input[j+1];
            Arrays.sort(scores);
            int lgap = 0;
            for(int j=1; j<scores.length; j++) {
                int dif = scores[j] - scores[j-1];
                if(lgap<dif)
                    lgap = dif;
            }
            sb.append("Class ").append(i).append('\n').append("Max ").append(scores[scores.length-1])
                    .append(", Min ").append(scores[0]).append(", Largest gap ").append(lgap).append('\n');
        }
        System.out.print(sb);
    }
}