package 백준.실버5.국회의원_선거;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1) {
            System.out.println(0);
            return;
        }
        PriorityQueue<Integer> votes = new PriorityQueue<>(Collections.reverseOrder());
        int cnt = 0;
        int myVotes = Integer.parseInt(br.readLine());
        for(int i=1; i<n; i++)
            votes.add(Integer.parseInt(br.readLine()));

        while(myVotes<=votes.peek()) {
            votes.add(votes.poll()-1);
            myVotes++;
            cnt++;
        }

        System.out.println(cnt);
    }
}