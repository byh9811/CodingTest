package 유틸;

public class Permutation {
    /**
     * <h1>중복이 없는 순열을 뽑는 함수</h1>
     * <li>swap 알고리즘을 이용하여 구현했다.</li>
     * <li>사전순 출력을 보장하지 않는다.</li>
     * <li>if문 안의 action()을 원하는 행동으로 교체하여 사용한다.</li>
     *
     * @param arr 순열을 만들 배열
     * @param depth 반복을 시작할 인덱스
     * @param remain 총 뽑을 수
     */
    public void permutation(int[] arr, int depth, int remain) {
        if(depth==remain) {
            action(arr, remain);
            return;
        }

        for(int i=depth; i<arr.length; i++) {
            Utils.swap(arr, depth, i);
            permutation(arr, depth+1, remain);
            Utils.swap(arr, depth, i);
        }
    }

    /**
     * <h1>순열이 완성되었을 때 실행되는 함수</h1>
     * <li>기본은 순열을 출력하는 기능이 구현되어 있다.</li>
     */
    private void action(int[] arr, int remain) {
        for(int i=0; i<remain; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}
