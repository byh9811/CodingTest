package 프로그래머스.레벨1.문자열_내_p와_y의_개수;

public class Solution {
    public boolean solution(String s) {
        int pNum = 0;
        int yNum = 0;

        for(int i=0; i<s.length(); i++) {
            String cur = s.substring(i, i+1).toLowerCase();
            if(cur.equals("p"))
                pNum++;
            else if(cur.equals("y"))
                yNum++;
        }

        return pNum==yNum ? true : false;
    }
}