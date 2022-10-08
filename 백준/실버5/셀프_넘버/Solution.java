package 백준.실버5.셀프_넘버;

import java.util.Arrays;

public class Solution {
    public void solution() throws Exception {
        boolean[] isSelfNumber = new boolean[10037];
        Arrays.fill(isSelfNumber, true);
        isSelfNumber[0] = false;
        for(int i=1; i<10000; i++) {
            int selfNumber = i;
            for(int j=i; j>0; j/=10)
                selfNumber += j%10;
            isSelfNumber[selfNumber] = false;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=10000; i++) {
            if(isSelfNumber[i]) {
                sb.append(i);
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}