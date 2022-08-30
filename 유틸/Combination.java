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
     * 총 뽑을 수의 크기
     */
    private int remain;

    public Combination(int[] arr, int remain) {
        this.arr = arr;
        this.remain = remain;
        ret = new int[remain];
        visited = new boolean[arr.length];
    }

    /**
     * <h1>조합의 경우의 수를 리턴하는 함수</h1>
     * <li>중복을 허용하지 않는 조합의 공식은 n!/r!*(n-r)!이다.</li>
     * <li>중복을 허용하는 조합은 <sub>n+r-1</sub>C<sub>r</sub>이다.</li>
     *
     * @param repeatable 중복 허용 여부
     * @return 경우의 수
     */
    public int getNumberOfCases(boolean repeatable) {

        if(!repeatable)
            return Utils.factorial(arr.length) / (Utils.factorial(remain)*Utils.factorial(arr.length-remain));
        else
            return Utils.factorial(arr.length+remain-1) / (Utils.factorial(remain)*Utils.factorial(arr.length-1));
    }

    /**
     * <h1>초기값을 설정하여 combination()을 실행하기 위한 함수</h1>
     * <li>코딩테스트에 사용시 combination()과 함께 사용한다.</li>
     * <li>start에 0, remain에 생성자 생성시 받은 remain을 주어 호출한다.</li>
     *
     */
    public void executeCombination() {
        combination(0, remain);
    }

    /**
     * <h1>초기값을 설정하여 reCombination()을 실행하기 위한 함수</h1>
     * <li>코딩테스트에 사용시 reCombination()과 함께 사용한다.</li>
     * <li>start에 0, remain에 생성자 생성시 받은 remain을 주어 호출한다.</li>
     *
     */
    public void executeCReCombination() {
        reCombination(0, remain);
    }

    /**
     * <h1>중복이 없는 조합을 뽑는 함수</h1>
     * <li>백트래킹을 이용하여 구현했다.</li>
     * <li>if문 안의 action()을 원하는 행동으로 교체하여 사용한다.</li>
     *
     * @param start 반복을 시작할 인덱스
     * @param remain 남은 반복 횟수
     */
    public void combination(int start, int remain) {
        if(remain==0) {
            action();
            return;
        }

        for(int i=start; i<arr.length; i++) {
            visited[i] = true;
            combination(i+1, remain-1);
            visited[i] = false;
        }
    }

    /**
     * <h1>중복이 있는 조합을 뽑는 함수</h1>
     * <li>백트래킹을 이용하여 구현했다.</li>
     * <li>if문 안의 actionRepeatable()을 원하는 행동으로 교체하여 사용한다.</li>
     *
     * @param start 반복을 시작할 인덱스
     * @param remain 남은 반복 횟수
     */
    public void reCombination(int start, int remain) {
        if(this.remain==remain) {
            actionRepeatable();
            return;
        }

        for(int i=start; i<arr.length; i++) {
            ret[this.remain-remain] = arr[i];
            combination(i, remain-1);
        }
    }

    /**
     * <h1>중복이 없는 조합이 완성되었을 때 실행되는 함수</h1>
     * <li>기본은 조합을 출력하는 기능이 구현되어 있다.</li>
     */
    private void action() {
        for(int i=0; i<arr.length; i++) {
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
