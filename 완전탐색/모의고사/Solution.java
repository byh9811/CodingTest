package 완전탐색.모의고사;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        HashMap<Integer, Integer> infos = new HashMap<>();
        infos.put(1, 0);
        infos.put(2, 0);
        infos.put(3, 0);

        for(int i=0; i<answers.length; i++) {
            if(answers[i]==i%5+1)
                infos.put(1, infos.get(1)+1);
            if((i%2==0 && answers[i]==2) || (i%8==1 && answers[i]==1) || (i%8==3 && answers[i]==3) || (i%8==5 && answers[i]==4) || (i%8==7 && answers[i]==5))
                infos.put(2, infos.get(2)+1);
            if((i%10==0 && answers[i]==3) || (i%10==1 && answers[i]==3) || (i%10==2 && answers[i]==1) || (i%10==3 && answers[i]==1) || (i%10==4 && answers[i]==2) ||
                    (i%10==5 && answers[i]==2) || (i%10==6 && answers[i]==4) || (i%10==7 && answers[i]==4) || (i%10==8 && answers[i]==5) || (i%10==9 && answers[i]==5))
                infos.put(3, infos.get(3)+1);
        }

        int max = Math.max(infos.get(1), Math.max(infos.get(2), infos.get(3)));
        ArrayList<Integer> answer = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry: infos.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if(value==max)
                answer.add(key);
        }

        answer.sort(null);
        return answer;
    }
}