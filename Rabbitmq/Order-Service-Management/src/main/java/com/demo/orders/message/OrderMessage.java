package com.demo.orders.message;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderMessage {

   private String orderId;


   private String productName;
   private int quantity;
   private String customerEmail;
}

