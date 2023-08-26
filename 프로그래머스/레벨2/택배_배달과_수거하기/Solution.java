package 프로그래머스.레벨2.택배_배달과_수거하기;

import java.util.*;

/*
1. 배달과 수거는 뒤에서부터 해놓는게 이득이다.
2. 따라서 마지막 인덱스부터 접근하여 택배차가 어디까지 이동할지 결정한다.
    - 배달 인덱스와 수거 인덱스는 따로 기록하며, 한번 배달과 수거시 큰 인덱스*2만큼 택배차가 이동해야 한다.
3. 현재 인덱스의 배달/수거를 cap만큼 줄인다.
    - 배달이나 수거할 상자가 cap보다 작을 경우, 인덱스를 줄이며 배달/수거할 인덱스를 설정하고 배달/수거한다.
    - 만약 인덱스가 음수가 되었을 경우, 더이상 배달할 곳이 없으므로 인덱스를 줄이는 것을 멈춘다.
4. 모든 배달과 수거가 남지 않을 때까지 반복한다.

풀이 시간: 1시간
*/
class Solution {
    long answer = 0;
    int deliIdx, pickIdx;
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        deliIdx = n - 1;
        pickIdx = n - 1;
        
        while(true) {
            if(deliIdx<0 && pickIdx<0) {
                break;
            }
            
            setNextDeliIdx(deliveries);
            setNextPickIdx(pickups);
            if(deliIdx<0) {
                answer += (pickIdx+1) * 2;
            } else if(pickIdx<0) {
                answer += (deliIdx+1) * 2;
            } else {
                answer += Math.max(deliIdx+1, pickIdx+1) * 2;
            }
            
            doDelivery(cap, deliveries);
            doPickup(cap, pickups);
        }
        
        return answer;
    }
    
    private void setNextDeliIdx(int[] deliveries) {
        while(deliIdx>=0 && deliveries[deliIdx]==0) {
            deliIdx--;
        }
    }
    
    private void setNextPickIdx(int[] pickups) {
        while(pickIdx>=0 && pickups[pickIdx]==0) {
            pickIdx--;
        }
    }
    
    private void doDelivery(int cap, int[] deliveries) {
        while(true) {
            setNextDeliIdx(deliveries);
            if(cap==0 || deliIdx<0) {
                return;
            }
            
            if(deliveries[deliIdx]<cap) {       // 배달할 것이 남음
                cap -= deliveries[deliIdx];
                deliveries[deliIdx] = 0;
            } else {        // 모두 배달
                deliveries[deliIdx] -= cap;
                cap = 0;
            }
        }
    }
    
    private void doPickup(int cap, int[] pickups) {
        while(true) {
            setNextPickIdx(pickups);
            if(cap==0 || pickIdx<0) {
                return;
            }
            
            if(pickups[pickIdx]<cap) {       // 수거할 것이 남음
                cap -= pickups[pickIdx];
                pickups[pickIdx] = 0;
            } else {        // 모두 수거
                pickups[pickIdx] -= cap;
                cap = 0;
            }
        }
    }

}