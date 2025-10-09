package com.example.demo;

public class DemoStubMain {

    public static void main(String[] args) {
        // Создаём инжектор, который вызывает ошибку каждый 10-й запрос
        ErrorInjector errorInjector = ErrorInjector.every10thFail();

        // Тест — просто проверим работу
        for (int i = 1; i <= 20; i++) {
            boolean failed = errorInjector.shouldFail();
            if (failed) {
                System.out.println("❌ Ошибка на запросе #" + i);
            } else {
                System.out.println("✅ Успех на запросе #" + i);
            }
        }
    }
}
