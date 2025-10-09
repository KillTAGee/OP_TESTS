package com.example.demo;

import java.security.SecureRandom;

public final class CardNumberGenerator {
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final int LENGTH = 12;

    private CardNumberGenerator() {}

    public static String generate12Digits() {
        StringBuilder sb = new StringBuilder(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            int digit = RANDOM.nextInt(10);
            sb.append(digit);
        }
        return sb.toString();
    }

    public static long generate12DigitsAsLong() {
        return Long.parseLong(generate12Digits());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(generate12Digits());
        }
    }
}
