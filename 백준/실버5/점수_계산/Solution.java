package 백준.실버5.점수_계산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Pair implements Comparable<Pair> {
    int idx;
    int score;

    public Pair(int idx, int score) {
        this.idx = idx;
        this.score = score;
    }

    @Override
    public int compareTo(Pair o) {
        return score-o.score;
    }
}

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i=1; i<9; i++)
            arr.add(new Pair(i, Integer.parseInt(br.readLine())));

        arr.sort(Collections.reverseOrder());
        int[] answer = new int[5];
        int sum = 0;
        for(int i=0; i<5; i++) {
            Pair cur = arr.get(i);
            sum += cur.score;
            answer[i] = cur.idx;
        }

        Arrays.sort(answer);
        System.out.println(sum);
        for(int i=0; i<5; i++)
            System.out.print(answer[i] + " ");
    }
}