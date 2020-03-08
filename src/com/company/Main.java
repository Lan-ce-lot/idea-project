package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //write your code here
//        System.out.println("Helloworld");
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            if(i!=1)
                System.out.println();
            BigInteger A = in.nextBigInteger();
            BigInteger B = in.nextBigInteger();
            System.out.println("Case "+i+":");
//            System.out.printf("Case %d:\n", i);
            System.out.println(A+" + "+B+" = "+A.add(B));
        }
    }
}
