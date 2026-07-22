package com.demo.orders.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.demo.orders.message.OrderMessage;
import com.demo.orders.model.Order.OrderStatus;
import com.demo.orders.service.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor
public class OrderConsumerService {
		
	private final OrderService orderService;
	
	@RabbitListener(queues="${rabbitmq.queue:orders.queue}")
	public void handleOrder(OrderMessage message) {
		
		log.info("[CONSUMER] Picked up order from queue | orderId={} product={}",message.getOrderId(),message.getProductName());
		
		try {
			orderService.updateOrderStatus(message.getOrderId(),OrderStatus.PROCESSING);
			
			processOrder(message);
			 
            // ── STEP 3: Mark the order as done ───────────────────────────────
            orderService.updateOrderStatus(message.getOrderId(), OrderStatus.COMPLETED);
            log.info("[CONSUMER] Order completed | orderId={}", message.getOrderId());
 
        } catch (Exception e) {
            // ── Something went wrong — mark it as failed ──────────────────────
            log.error("[CONSUMER] Order failed | orderId={} error={}",
                    message.getOrderId(), e.getMessage());
            orderService.updateOrderStatus(message.getOrderId(), OrderStatus.FAILED);
 
            // Re-throwing the exception tells RabbitMQ "I couldn't handle this"
            // Spring's retry config will retry it a few times, then discard it (or DLQ it)
            throw new RuntimeException("Order processing failed", e);
		
	}
	}
	 // ── Your actual business logic lives here ─────────────────────────────────
    // Nothing RabbitMQ-specific. Just a normal private method.
    private void processOrder(OrderMessage message) throws InterruptedException {
        log.info("[CONSUMER] Processing: {} x {} for {}",
                message.getQuantity(), message.getProductName(), message.getCustomerEmail());
 
        // Simulate work taking some time (e.g. calling external payment API)
        Thread.sleep(1000);
 
        log.info("[CONSUMER] Processing done for orderId={}", message.getOrderId());
    }
	
		
}
