package 프로그래머스.레벨2.당구_연습;

import java.util.*;

/*
1. 네 다이로 모두 쿠션을 해보고 가장 짧은 방법을 저장한다.
2. 각 다이에 따라 도착 지점의 좌표를 보정한 후 두 점 사이의 거리를 계산한다.
    1. 왼쪽 다이는 도착 지점의 좌표를 x축 반전하여 계산한다.
    2. 오른쪽 다이는 도착 지점의 좌표를 m-x만큼 더하여 계산한다.
    3. 위쪽 다이는 도착 지점의 좌표를 n-y만큼 더하여 계산한다.
    4. 아래쪽 다이는 도착 지점의 좌표를 y축 반전하여 계산한다.
3. 단, 벽에 닿기 전에 공을 맞추면 안되므로 각 다이를 맞출 수 있는지 조건을 계산해봐야 한다.
    1. 왼쪽 다이는 도착 지점과 시작 지점의 y좌표가 같고, 도착 지점의 x좌표가 시작 지점의 x좌표보다 작으면 안된다.
    2. 오른쪽 다이는 도착 지점과 시작 지점의 y좌표가 같고, 도착 지점의 x좌표가 시작 지점의 x좌표보다 크면 안된다.
    3. 위쪽 다이는 도착 지점과 시작 지점의 x좌표가 같고, 도착 지점의 y좌표가 시작 지점의 y좌표보다 크면 안된다.
    4. 아래쪽 다이는 도착 지점과 시작 지점의 x좌표가 같고, 도착 지점의 y좌표가 시작 지점의 y좌표보다 작으면 안된다.
    
풀이 시간: 47분 40초
*/
class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for(int i=0; i<answer.length; i++) {
            answer[i] = getMinDis(m, n, startX, startY, balls[i]);
        }
        return answer;
    }
    
    private int getMinDis(int m, int n, int startX, int startY, int[] ball) {
        int min = Integer.MAX_VALUE;
        int destX = ball[0];
        int destY = ball[1];
        
        for(int i=0; i<4; i++) {
            min = Math.min(min, calDis(i, m, n, startX, startY, destX, destY));
        }
        
        return min;
    }
    
    private int calDis(int dir, int m, int n, int startX, int startY, int destX, int destY) {
        switch(dir) {
            case 0: return calLeftDis(startX, startY, destX, destY);
            case 1: return calRightDis(m, startX, startY, destX, destY);
            case 2: return calUpDis(n, startX, startY, destX, destY);
            default: return calDownDis(startX, startY, destX, destY);
        }
    }
    
    private int calLeftDis(int startX, int startY, int destX, int destY) {
        if(startY==destY && startX>destX) {      // 왼쪽 다이로 칠 수 없는 경우
            return Integer.MAX_VALUE;
        }
        
        return (int)Math.pow(startX+destX, 2) + (int)Math.pow(startY-destY, 2);
    }
    
    private int calRightDis(int m, int startX, int startY, int destX, int destY) {
        if(startY==destY && startX<destX) {
            return Integer.MAX_VALUE;
        }
        
        return (int)Math.pow(startX-(m+m-destX), 2) + (int)Math.pow(startY-destY, 2);
    }
    
    private int calUpDis(int n, int startX, int startY, int destX, int destY) {
        if(startX==destX && startY<destY) {
            return Integer.MAX_VALUE;
        }
        
        return (int)Math.pow(startX-destX, 2) + (int)Math.pow(startY-(n+n-destY), 2);
    }
    
    private int calDownDis(int startX, int startY, int destX, int destY) {
        if(startX==destX && startY>destY) {
            return Integer.MAX_VALUE;
        }
        
        return (int)Math.pow(startX-destX, 2) + (int)Math.pow(startY+destY, 2);
    }
}