package com.demo.orders.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.demo.orders.config.RabbitMQConfig;
import com.demo.orders.message.OrderMessage;
import com.demo.orders.model.Order;
import com.demo.orders.model.Order.OrderStatus;
import com.demo.orders.repository.OrderRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderRepository orderRepository;
	private final RabbitTemplate rabbitTemplate;
	
	@Transactional
	public Order placeOrder(String  productName, int quantity, double  price, String email) {
		Order order =Order.builder()
					.productName(productName)
					.quantity(quantity)
					.price(price)
					.customerEmail(email)
					.status(OrderStatus.PLACED)
					.createdAt(LocalDateTime.now())
					.updatedAt(LocalDateTime.now())
					.build();
		
		Order savedOrder =orderRepository.save(order);
		log.info("[Service] Order saved to db with id={} status=PLACED",savedOrder.getId());
		
		OrderMessage message =OrderMessage.builder()
								.orderId(savedOrder.getId())
								.productName(savedOrder.getProductName())
								.quantity(savedOrder.getQuantity())
								.customerEmail(savedOrder.getCustomerEmail())
								.build();
		
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE,RabbitMQConfig.ROUTING_KEY,message);
		
		log.info("[Service] Message sent to RabbitMQ for orderId ={}",savedOrder.getId());
		
		return savedOrder;
	}
	
	 @Transactional
	    public void updateOrderStatus(String orderId, OrderStatus newStatus) {
	        orderRepository.findById(orderId).ifPresent(order -> {
	            order.setStatus(newStatus);
	            order.setUpdatedAt(LocalDateTime.now());
	            orderRepository.save(order);
	            log.info("[SERVICE] Order {} status updated to {}", orderId, newStatus);
	        });
	    }
	 
	    public List<Order> getOrder() {
	        return orderRepository.findAll();
	    }

}
