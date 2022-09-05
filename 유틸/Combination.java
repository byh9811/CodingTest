package 유틸;

public class Combination {
    /**
     * 조합을 만들어낼 배열
     */
    private int[] arr;

    /**
     * 조합에 뽑혔는지 확인할 배열
     */
    private boolean[] visited;

    /**
     * 뽑힌 원소를 저장할 배열
     */
    private int[] ret;

    /**
     * 총 배열의 크기
     */
    private int n;

    /**
     * 총 뽑을 수의 크기
     */
    private int r;

    public Combination(int[] arr, int r) {
        this.arr = arr;
        this.r = r;
        n = arr.length;
        ret = new int[r];
        visited = new boolean[arr.length];
    }

    /**
     * <h1>조합의 경우의 수를 리턴하는 함수</h1>
     * <li>중복을 허용하지 않는 조합의 공식은 n!/r!*(n-r)!이다.</li>
     * <li>중복을 허용하는 조합은 <sub>n+r-1</sub>C<sub>r</sub>이다.</li>
     * <li>하지만 N이 큰 수 일때를 대비하여 팩토리얼을 사용하지 않고 정의를 이용하여 구했다.</li>
     *
     * @param repeatable 중복 허용 여부
     * @return 경우의 수
     */
    public long getNumberOfCases(boolean repeatable) {
        long ret = 1;

        if(repeatable) {
            for(int i=0; i<r; i++) {
                ret *= n + r - 1 - i;
                ret /= i + 1;
            }
        } else {
            for(int i=0; i<r; i++) {
                ret *= n - i;
                ret /= i + 1;
            }
        }

        return ret;
    }

    /**
     * <h1>초기값을 설정하여 combination()을 실행하기 위한 함수</h1>
     * <li>코딩테스트에 사용시 combination()과 함께 사용한다.</li>
     * <li>start에 0, remain에 생성자 생성시 받은 remain을 주어 호출한다.</li>
     *
     */
    public void executeCombination() {
        combination(0, 0);
    }

    /**
     * <h1>초기값을 설정하여 reCombination()을 실행하기 위한 함수</h1>
     * <li>코딩테스트에 사용시 reCombination()과 함께 사용한다.</li>
     * <li>start에 0, remain에 생성자 생성시 받은 remain을 주어 호출한다.</li>
     *
     */
    public void executeReCombination() {
        reCombination(0, 0);
    }

    /**
     * <h1>중복이 없는 조합을 뽑는 함수</h1>
     * <li>백트래킹을 이용하여 구현했다.</li>
     * <li>if문 안의 action()을 원하는 행동으로 교체하여 사용한다.</li>
     *
     * @param start 반복을 시작할 인덱스
     * @param depth 현재 호출 깊이
     */
    public void combination(int start, int depth) {
        if(depth==r) {
            action();
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(i+1, depth+1);
            visited[i] = false;
        }
    }

    /**
     * <h1>중복이 있는 조합을 뽑는 함수</h1>
     * <li>백트래킹을 이용하여 구현했다.</li>
     * <li>if문 안의 actionRepeatable()을 원하는 행동으로 교체하여 사용한다.</li>
     *
     * @param start 반복을 시작할 인덱스
     * @param depth 현재 호출 깊이
     */
    public void reCombination(int start, int depth) {
        if(depth==r) {
            actionRepeatable();
            return;
        }

        for(int i=start; i<n; i++) {
            ret[depth] = arr[i];
            reCombination(i, depth+1);
        }
    }

    /**
     * <h1>중복이 없는 조합이 완성되었을 때 실행되는 함수</h1>
     * <li>기본은 조합을 출력하는 기능이 구현되어 있다.</li>
     */
    private void action() {
        for(int i=0; i<n; i++) {
            if(visited[i])
                System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    /**
     * <h1>중복이 없는 조합이 완성되었을 때 실행되는 함수</h1>
     * <li>기본은 조합을 출력하는 기능이 구현되어 있다.</li>
     */
    private void actionRepeatable() {
        for(int i=0; i<ret.length; i++) {
            System.out.print(ret[i] + " ");
        }

        System.out.println();
    }
}
