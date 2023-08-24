package com.example.hello.core_re.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
