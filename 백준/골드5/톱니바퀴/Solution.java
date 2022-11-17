package 백준.골드5.톱니바퀴;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Boolean>[] gear = new Deque[4];
        for(int i=0; i<4; i++) {
            String input = br.readLine();
            Deque<Boolean> deque = new LinkedList<>();
            for(int j=0; j<input.length(); j++)
                deque.add(input.charAt(j)=='1');
            gear[i] = deque;
        }
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            boolean turnRight = Integer.parseInt(st.nextToken())==1;
            turnGear(gear[idx], turnRight);
            for(int j=idx-1; j>=0; j--) {
                if(turnRight) {
                    if(checkPole(gear[j], 2)==gear[j+1].peekLast())
                        break;
                    else
                        turnGear(gear[j], (idx-j)%2==0);
                } else {
                    if(checkPole(gear[j], 2)==checkPole(gear[j+1], 5))
                        break;
                    else
                        turnGear(gear[j], (idx-j)%2!=0);
                }
            }
            for(int j=idx+1; j<4; j++) {
                if(turnRight) {
                    if(checkPole(gear[j], 6)==checkPole(gear[j-1], 3))
                        break;
                    else
                        turnGear(gear[j], (idx-j)%2==0);
                } else {
                    if(checkPole(gear[j], 6)==checkPole(gear[j-1], 1))
                        break;
                    else
                        turnGear(gear[j], (idx-j)%2!=0);
                }
            }
        }

        int answer = 0;
        for(int i=0; i<4; i++) {
            System.out.println(gear[i].peekFirst());
            if(gear[i].peekFirst())
                answer += Math.pow(2, i);
        }

        System.out.println(answer);
    }

    private void turnGear(Deque<Boolean> gear, boolean turnRight) {
        System.out.println(turnRight);
        if(turnRight)
            gear.addFirst(gear.pollLast());
        else
            gear.addLast(gear.pollFirst());
    }

    private boolean checkPole(Deque<Boolean> gear, int idx) {
        System.out.print(idx + " ");
        boolean pole;
        Stack<Boolean> stk = new Stack<>();

        if(idx<4) {
            for(int i=0; i<idx; i++)
                stk.add(gear.pollFirst());
            pole = gear.peekFirst();
            for(int i=0; i<idx; i++)
                gear.addFirst(stk.pop());

        } else {
            for(int i=7; i>idx; i--)
                stk.add(gear.pollLast());
            pole = gear.peekLast();
            for(int i=7; i>idx; i--)
                gear.addLast(stk.pop());
        }

        System.out.println(pole);
        return pole;
    }
}