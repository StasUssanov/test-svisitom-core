package com.example.testsvisitomcore.status.controller;

import com.example.testsvisitomcore.status.dto.request.StatusRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
@Tag(name = "Управление ")
public class StatusController extends StatusBaseController {

    @PostMapping
    @Operation(description = "Создать ")
    public ResponseEntity<?> createStatus(@RequestBody StatusRequest body) {
        try {
            return ResponseEntity.ok(statusService.createStatus(body));
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @GetMapping("/list")
    @Operation(description = "Получить список ")
    public ResponseEntity<?> getCompanies() {
        try {
            return ResponseEntity.ok(statusService.getStatuses());
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @PutMapping
    @Operation(description = "Обновить ")
    public ResponseEntity<?> updateStatuses(@RequestBody StatusRequest body) {
        try {
            return ResponseEntity.ok(statusService.updateStatus(body));
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @PutMapping("/list")
    @Operation(description = "Обновить список (реализованно только изменения стратуса)")
    public ResponseEntity<?> updateStatuses(@RequestBody List<StatusRequest> body) {
        try {
            return ResponseEntity.ok(statusService.updateStatuses(body));
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

}
