package 프로그래머스.레벨2.이모티콘_할인행사;

/*
1. 사용자가 이모티콘을 많이 사도록 할인율을 높이면서 이모티콘 플러스에 가입하도록 최대한 구매 비용을 높게 유지해야 한다.
2. 10~40%의 할인율을 적용하여 모든 사용자의 emoticon에 대한 행동을 보는 방법은 depth가 7인 dfs를 이용해야 하므로, 4*7 가지의 경우가 존재하므로 해볼 수 있다.
3. 각 사용자에 대해 할인율을 적용한 구매할 이모티콘과 그 가격의 합을 구하고, 합이 이모티콘플러스의 값을 넘지 않는다면 매출액에 더한다.
4. 이모티콘 플러스를 사는게 이득일 경우, 가입자 수를 1 더한다.
5. 가입자 수가 기존보다 높거나 같으면서 매출액이 높은 경우 정답을 갱신한다.

- 부동소수점 연산 때문에 에러가 발생하므로 소수 나눗셈을 사용하지 않아야 한다.

풀이 시간: 58분
*/
class Solution {
    long emoPlusCntMax = 0;
    long salesMax = 0;
    double[] saleRates = {1, 2, 3, 4};
    
    public long[] solution(int[][] users, int[] emoticons) {
        
        dfs(0, users, emoticons, new long[users.length]);
        
        return new long[] {emoPlusCntMax, salesMax};
    }
    
    private void dfs(int depth, int[][] users, int[] emoticons, long[] acc) {
        if(depth==emoticons.length) {
            long emoPlusCnt = 0;
            long sales = 0;
            
            for(int i=0; i<users.length; i++) {     // 이모티콘 플러스를 사용하는 게 이득인 사용자 색출
                if(acc[i]>=users[i][1]) {
                    emoPlusCnt++;
                } else {
                    sales += acc[i];
                }
            }
            
            if(emoPlusCntMax < emoPlusCnt) {
                emoPlusCntMax = emoPlusCnt;
                salesMax = sales;
            } else if(emoPlusCntMax==emoPlusCnt && salesMax<sales) {
                salesMax = sales;
            }
            
            return;
        }
        
        for(double saleRate: saleRates) {
            for(int i=0; i<users.length; i++) {
                if(saleRate*10>=users[i][0]) {
                    acc[i] += emoticons[depth] * (10-saleRate) / 10;
                }
            }
            dfs(depth+1, users, emoticons, acc);
            for(int i=0; i<users.length; i++) {
                if(saleRate*10>=users[i][0]) {
                    acc[i] -= emoticons[depth] * (10-saleRate) / 10;
                }
            }
        }
    }
}