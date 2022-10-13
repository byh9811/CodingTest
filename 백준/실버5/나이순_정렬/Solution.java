package 백준.실버5.나이순_정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Member implements Comparable<Member> {
    int idx;
    int age;
    String name;

    public Member(int idx, int age, String name) {
        this.idx = idx;
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Member m) {
        if(age==m.age)
            return idx-m.idx;
        else
            return age- m.age;
    }
}

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            members[i] = new Member(i, Integer.parseInt(input[0]), input[1]);
        }

        Arrays.sort(members);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            Member member = members[i];
            sb.append(member.age);
            sb.append(" ");
            sb.append(member.name);
            sb.append("\n");
        }

        System.out.print(sb);
    }
}