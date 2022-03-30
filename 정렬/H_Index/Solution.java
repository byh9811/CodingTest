package 정렬.H_Index;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int solution(int[] citations) {
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, Collections.reverseOrder());
        int index = 0;
        for(; index<arr.length; index++) {
            if(arr[index]<index+1)
                break;
        }

        return index;
    }
}