package com.example.demo;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public final class DelayUtil {
    private DelayUtil() {}

    public static void sleepMillis(long millis) {
        if (millis <= 0) return;
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void sleepRandomBetween(long minMillis, long maxMillis) {
        long min = Math.min(minMillis, maxMillis);
        long max = Math.max(minMillis, maxMillis);
        long delay = ThreadLocalRandom.current().nextLong(min, max + 1);
        sleepMillis(delay);
    }

    public static void sleep(long time, TimeUnit unit) {
        if (time <= 0) return;
        try {
            unit.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
