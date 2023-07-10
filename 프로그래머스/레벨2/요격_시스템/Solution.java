package 프로그래머스.레벨2.요격_시스템;

import java.util.*;

/*
1. 미사일의 개수는 최대 50만이지만, 구간은 최대 1억인 데다 실수도 포함 가능.
    1. 따라서 미사일의 개수를 사용하는 NlogN알고리즘을 이용해야 할 듯.
2. 가장 많이 뚫을 수 있는 구간부터 뚫는 그리디 방식을 택하면?
    1. 끝 좌표를 오름차순으로 정렬하고 -> NlogN
    2. 한 미사일의 끝좌표 바로 직전을 관통하고, 그 좌표를 기록하고, 사용한 미사일의 개수를 1 더한다.
    3. 2번을 정렬한 미사일에 대해 반복한다 -> N
    4. 만약 미사일의 시작 좌표가 기록한 좌표보다 작을 경우, 이미 관통되었으므로 넘어갈 수 있다.
    
소요시간: 28분 23초
*/
class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        
        int usedMissile = 0;
        int attackedPoint = 0;
        
        for(int i=0; i<targets.length; i++) {
            int[] target = targets[i];
            if(target[0]<attackedPoint) {
                continue;
            }
            
            attackedPoint = target[1];
            usedMissile++;
        }
        
        return usedMissile;
    }
}