package 백준.실버5.올림픽;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Nation implements Comparable<Nation> {
    int idx;
    int gold;
    int silver;
    int bronze;

    public Nation(int idx, int gold, int silver, int bronze) {
        this.idx = idx;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    @Override
    public int compareTo(Nation o) {
        if(gold!=o.gold)
            return o.gold-gold;
        else if(silver!=o.silver)
            return o.silver-silver;
        else
            return o.bronze-bronze;
    }
}

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        ArrayList<Nation> arr = new ArrayList<>();
        for(int i=0; i<N; i++) {
            int[] input2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr.add(new Nation(input2[0], input2[1], input2[2], input2[3]));
        }

        arr.sort(null);

        int rank = 1;
        int cnt = 1;
        for(int i=0; i<N-1; i++) {
            Nation cur = arr.get(i);
            Nation next = arr.get(i+1);

            if(cur.idx==K) {
                System.out.print(rank);
                return;
            }

            if(cur.gold==next.gold && cur.silver==next.silver && cur.bronze==next.bronze) {
                cnt++;
            } else {
                rank += cnt;
                cnt = 1;
            }
        }

        System.out.print(rank);
    }
}