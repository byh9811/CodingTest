import 이분탐색.입국심사.Solution;

public class Main {
    public static void main(String[] args) {
        int[] times = {7, 10};

        System.out.println(new Solution().solution(6, times));
    }

    private static void print(int[][] arr) {
        for(int[] elem: arr) {
            for(int elem2: elem)
                System.out.print(elem2 + " ");
            System.out.println();
        }
    }

    private static void print(int[] arr) {
        for(int elem: arr) {
            System.out.print(elem + " ");
        }
    }
}
