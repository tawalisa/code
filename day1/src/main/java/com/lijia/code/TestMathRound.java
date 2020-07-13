package com.lijia.code;

public class TestMathRound {
    public static void main(String[] args) {
        System.out.println(calculateOCSObjectIDsRate(0.4F, 8));
        System.out.println(calculateOCSObjectIDsRate(0.4F, 7));
    }

    private static int calculateOCSObjectIDsRate(float ocsObjectRate, int objectIdCount) {
        float res = ocsObjectRate * objectIdCount;
        return res < 1 ? 1 : Math.round(res);
    }
}
