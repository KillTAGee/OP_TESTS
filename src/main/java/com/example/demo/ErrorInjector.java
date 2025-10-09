package com.example.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class ErrorInjector {

    // Счётчик всех вызовов
    private final AtomicInteger counter = new AtomicInteger(0);
    // Каждые N вызовов будет ошибка
    private final int interval;

    public ErrorInjector(int interval) {
        this.interval = interval;
    }

    /**
     * Проверяет, нужно ли сгенерировать ошибку.
     * Например, если interval = 10 — то каждый 10-й запрос вернёт ошибку.
     */
    public boolean shouldFail() {
        int current = counter.incrementAndGet();
        if (current % interval == 0) {
            System.out.println("⚠️  Simulated failure on request #" + current);
            return true;
        }
        return false;
    }

    // Статический “инжектор по умолчанию”
    public static ErrorInjector every10thFail() {
        return new ErrorInjector(10); // 1 ошибка на каждые 10 вызовов
    }
}
