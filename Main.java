import DP.도둑질.Solution;

public class Main {
    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1};

        print(new Solution().solution(money));
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
