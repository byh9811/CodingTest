import 프로그래머스.고득점_Kit.힙.더_맵게.Solution;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 9, 10, 12};

        print(new Solution().solution(numbers, 7));
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
