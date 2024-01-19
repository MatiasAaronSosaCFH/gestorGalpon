package com.GestorGalpon.service.abstraction;

import java.util.List;

import com.GestorGalpon.models.order.dto.RequestOrder;
import com.GestorGalpon.models.order.dto.ResponseOrder;

public interface OrderService {
    ResponseOrder createOrder(RequestOrder order);
    //ResponseOrder updateIsPresent(Long orderId, Boolean isPresent);
    ResponseOrder findById(Long orderId);
    List<ResponseOrder> findAllOrderAvailable();
    ResponseOrder updateOrder(Long orderId, Long orderDetailId, Long productId, Integer itemsNumber);
    
    
}
