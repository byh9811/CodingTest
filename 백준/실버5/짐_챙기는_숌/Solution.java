package 백준.실버5.짐_챙기는_숌;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int box = 0, basket = 0;
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        if(N==0) {
            System.out.println(0);
            return;
        }

        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<arr.length; i++)
            arr[i] = Integer.parseInt(input2[i]);

        for(int elem: arr) {
            if(basket+elem>M) {
                basket = 0;
                box++;
            }

            basket += elem;
        }

        System.out.println(basket==0 ? box : box+1);
    }
}