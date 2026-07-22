package com.demo.orders.controller;

import com.demo.orders.model.Order;
import com.demo.orders.service.OrderService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// ─── COMPLETELY NORMAL @RestController ────────────────────────────────────────
//
// There is ZERO RabbitMQ code here.
// The controller just calls OrderService, exactly as you're used to.
// RabbitMQ is an implementation detail hidden inside the service.

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService; // ← normal service injection

    // POST /api/orders
    // Body: { "productName": "Keyboard", "quantity": 1, "price": 99.99, "customerEmail": "a@b.com" }
    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest request) {

        // This call does two things inside:
        //   1. Saves the order to DB (status=PLACED)
        //   2. Sends a message to RabbitMQ
        // Both happen in OrderService. The controller doesn't care which.

        Order order = orderService.placeOrder(
                request.productName(),
                request.quantity(),
                request.price(),
                request.customerEmail()
        );

        // We return 202 Accepted (not 201 Created) because the order isn't
        // fully processed yet — it's queued. 202 means "we got it, working on it."
        return ResponseEntity.accepted().body(order);
    }

    // GET /api/orders/{id}
    // Check the current status of an order — useful to see it change from PLACED → COMPLETED
    @GetMapping()
    public ResponseEntity<List<Order>> getOrder() {
        return ResponseEntity.ok(orderService.getOrder());
    }

    // Simple request body record
    record OrderRequest(String productName, int quantity, double price, String customerEmail) {}
}