package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mock")
public class MockController {

    // создаём инжектор, который выдает ошибку каждый 10-й вызов
    private final ErrorInjector errorInjector = ErrorInjector.every10thFail();

    @GetMapping("/card")
    public ResponseEntity<?> getCard() {
        // проверяем — нужно ли сгенерировать ошибку
        if (errorInjector.shouldFail()) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "simulated", "reason", "every 10th request failed"));
        }

        // если всё ок — генерируем карту
        String card = CardNumberGenerator.generate12Digits();
        return ResponseEntity.ok(Map.of("card", card));
    }
}
