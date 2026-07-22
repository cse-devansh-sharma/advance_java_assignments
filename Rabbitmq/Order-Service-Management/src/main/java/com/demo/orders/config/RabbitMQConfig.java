package com.demo.orders.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// ─── THIS IS THE ONLY RABBITMQ-SPECIFIC FILE ─────────────────────────────────
//
// Think of this file as "setting up the post office".
//
// Before you can send a letter (message), you need:
//   1. A MAILBOX (Queue)    — where messages wait
//   2. A SORTING ROOM (Exchange) — decides which mailbox to put mail in
//   3. A ROUTING RULE (Binding) — "mail labeled X goes to mailbox Y"
//   4. A POSTMAN (RabbitTemplate) — the thing that actually delivers mail
//
// Once this config is in place, the rest of your code (Service, Controller)
// just calls rabbitTemplate.convertAndSend(...) and forgets about it.

@Configuration
public class RabbitMQConfig {

    // These are the names we'll use everywhere. Just string constants.
    public static final String QUEUE       = "orders.queue";
    public static final String EXCHANGE    = "orders.exchange";
    public static final String ROUTING_KEY = "orders.key";

    // ── 1. QUEUE ──────────────────────────────────────────────────────────────
    // The waiting room where messages sit until the consumer picks them up.
    // durable(true) = survives if RabbitMQ restarts (messages not lost)
    @Bean
    public Queue ordersQueue() {
        return QueueBuilder.durable(QUEUE).build();
    }

    // ── 2. EXCHANGE ───────────────────────────────────────────────────────────
    // The router. Producer sends to exchange, exchange routes to queue(s).
    // Direct = route by exact routing key match (simplest type)
    @Bean
    public DirectExchange ordersExchange() {
        return new DirectExchange(EXCHANGE);
    }

    // ── 3. BINDING ────────────────────────────────────────────────────────────
    // The rule: "when a message arrives at ordersExchange with routing key
    // 'orders.key', put it in ordersQueue"
    @Bean
    public Binding ordersBinding() {
        return BindingBuilder
                .bind(ordersQueue())
                .to(ordersExchange())
                .with(ROUTING_KEY);
    }

    // ── 4. MESSAGE CONVERTER ──────────────────────────────────────────────────
    // Without this, Spring sends Java-serialized bytes (ugly and brittle).
    // With this, Spring sends clean JSON. The consumer also uses this to
    // convert JSON bytes back to an OrderMessage object.
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // ── 5. RABBITTEMPLATE ─────────────────────────────────────────────────────
    // The main API you call to send messages. Think of it like JdbcTemplate
    // but for RabbitMQ. You inject this wherever you need to publish.
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}