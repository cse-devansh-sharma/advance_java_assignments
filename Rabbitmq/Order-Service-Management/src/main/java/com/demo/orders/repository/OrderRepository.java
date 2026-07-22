package com.demo.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.orders.model.Order;

public interface OrderRepository extends JpaRepository<Order,String>{

}
