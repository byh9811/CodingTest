import 이분탐색.징검다리.Solution;

public class Main {
    public static void main(String[] args) {
        int[] rocks = {2, 14, 11, 21, 17};

        print(new Solution().solution(25, rocks, 2));
    }

    private static void print(Object[][] arr) {
        for(Object[] elem: arr) {
            for(Object elem2: elem)
                System.out.print(elem2 + " ");
            System.out.println();
        }
    }

    private static void print(Object[] arr) {
        for(Object elem: arr) {
            System.out.print(elem + " ");
        }
    }

    private static void print(Object o) {
        System.out.println(o);
    }
}
