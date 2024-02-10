package Structures;

import java.util.Random;

public class RandomIntArray {
     public static int[] gen1DArray(int n) {
         int[] res = new int[n];
         Random generator = new Random();

         for (int i = 0; i < n - 1; i++) res[i] = generator.nextInt();

         return res;
    }
}
