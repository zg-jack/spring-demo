package com.xiangxue.jack.service.order;

public interface OrderService {
    
    public String queryOrder(String orderId);
    
    public String addOrder(Order order);
}
