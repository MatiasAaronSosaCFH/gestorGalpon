package com.GestorGalpon.service.abstraction;

import com.GestorGalpon.models.order.dto.RequestOrder;
import com.GestorGalpon.models.order.dto.ResponseOrder;

public interface OrderService {
    ResponseOrder createOrder(RequestOrder order);
    ResponseOrder updateOrder(RequestOrder order);
    ResponseOrder findById(Long orderId);
    
    
}
