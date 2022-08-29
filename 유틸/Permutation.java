package 유틸;

public class Permutation {
    /**
     * 순열을 만들어낼 소스 배열
     */
    private int[] arr;

    /**
     * 순열을 저장할 배열
     */
    private int[] ret;

    /**
     * 순열에 뽑혔는지 확인할 배열
     */
    private boolean[] visited;

    /**
     * 총 뽑을 수의 크기
     */
    private int remain;

    public Permutation(int[] arr, int remain) {
        this.arr = arr;
        this.remain = remain;
        ret = new int[remain];
        visited = new boolean[arr.length];
    }

    /**
     * <h1>경우의 수를 리턴하는 함수</h1>
     * <li>중복을 허용할 경우 공식은 n<sup>2</sup>이다.</li>
     * <li>중복을 허용하지 않을 경우 공식은 n!/(n-r)!이다.</li>
     *
     * @param repeatable 중복 허용 여부
     * @return 경우의 수
     */
    public int getNumberOfCases(boolean repeatable) {
        return repeatable ? arr.length * arr.length : Utils.factorial(arr.length) / Utils.factorial(arr.length-remain);
    }

    /**
     * <h1>중복이 없는 순열을 뽑는 함수</h1>
     * <li>재귀호출을 이용하여 구현했다.</li>
     * <li>사전순 출력을 보장하며 시간복잡도가 높다.</li>
     * <li>if문 안의 action()을 원하는 행동으로 교체하여 사용한다.</li>
     *
     * @param depth 반복을 시작할 인덱스
     */
    public void permutationVisited(int depth) {
        if(depth==remain) {
            actionVisited();
            return;
        }

        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                ret[depth] = arr[i];
                permutationVisited(depth+1);
                visited[i] = false;
            }
        }
    }

    /**
     * <h1>중복이 없는 순열을 뽑는 함수</h1>
     * <li>swap 알고리즘을 이용하여 구현했다.</li>
     * <li>사전순 출력을 보장하지 않으며 시간복잡도가 낮다.</li>
     * <li>if문 안의 action()을 원하는 행동으로 교체하여 사용한다.</li>
     *
     * @param depth 반복을 시작할 인덱스
     */
    public void permutationSwap(int depth) {
        if(depth==remain) {
            actionSwap();
            return;
        }

        for(int i=depth; i<arr.length; i++) {
            Utils.swap(arr, depth, i);
            permutationSwap(depth+1);
            Utils.swap(arr, depth, i);
        }
    }

    /**
     * <h1>중복이 있는 순열을 뽑는 함수</h1>
     * <li>재귀호출을 이용하여 구현했다.</li>
     * <li>if문 안의 action()을 원하는 행동으로 교체하여 사용한다.</li>
     *
     * @param depth 반복을 시작할 인덱스
     */
    public void rePermutation(int depth) {
        if(depth==remain) {
            actionVisited();
            return;
        }

        for(int i=0; i<arr.length; i++) {
            ret[depth] = arr[i];
            permutationVisited(depth+1);
        }
    }

    /**
     * <h1>초기값을 설정하여 permutationVisited()를 실행하기 위한 함수</h1>
     * <li>코딩테스트에 사용시 permutationVisited()와 함께 사용한다.</li>
     * <li>depth에 0을 주어 호출한다.</li>
     */
    public void executePermutationVisited() {
        permutationVisited(0);
    }

    /**
     * <h1>초기값을 설정하여 permutationSwap()를 실행하기 위한 함수</h1>
     * <li>코딩테스트에 사용시 permutationSwap()와 함께 사용한다.</li>
     * <li>depth에 0을 주어 호출한다.</li>
     */
    public void executePermutationSwap() {
        permutationSwap(0);
    }


    /**
     * <h1>초기값을 설정하여 rePermutation()를 실행하기 위한 함수</h1>
     * <li>코딩테스트에 사용시 rePermutation()와 함께 사용한다.</li>
     * <li>depth에 0을 주어 호출한다.</li>
     */
    public void executeRePermutation() {
        rePermutation(0);
    }

    /**
     * <h1>permutationVisited()로 순열이 완성되었을 때 실행되는 함수</h1>
     * <li>기본은 순열을 출력하는 기능이 구현되어 있다.</li>
     */
    private void actionVisited() {
        for(int i=0; i<remain; i++) {
            System.out.print(ret[i] + " ");
        }

        System.out.println();
    }

    /**
     * <h1>permutationSwap()으로 순열이 완성되었을 때 실행되는 함수</h1>
     * <li>기본은 순열을 출력하는 기능이 구현되어 있다.</li>
     */
    private void actionSwap() {
        for(int i=0; i<remain; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}