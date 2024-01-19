package com.GestorGalpon.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.GestorGalpon.models.order.Order;
import com.GestorGalpon.models.order.dto.RequestOrder;
import com.GestorGalpon.models.order.dto.ResponseOrder;
import com.GestorGalpon.models.orderdetails.OrderDetail;
import com.GestorGalpon.repository.OrderDetailRepository;
import com.GestorGalpon.repository.OrderRepository;
import com.GestorGalpon.service.abstraction.OrderService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImp implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    @Override
    public ResponseOrder createOrder(RequestOrder order) {
        return new ResponseOrder(orderRepository.save(new Order(order)));
    }

    @Override
    public ResponseOrder updateIsPresent(Long orderId, Boolean isPresent) {

      
        if(isPresent == true){
            return new ResponseOrder(orderRepository.updateIsPresent(orderId,false).orElse(null));
        }else{
            return new ResponseOrder(orderRepository.updateIsPresent(orderId,true).orElse(null));
        }


    }

    @Override
    public ResponseOrder findById(Long orderId) {
        return new ResponseOrder(orderRepository.findById(orderId).orElse(null));
    }

    @Override
    public List<ResponseOrder> findAllOrderAvailable() {

        return orderRepository.findAllOrderAvailable().stream().map(ResponseOrder::new).toList();
    }

    @Override
    public ResponseOrder updateOrder(Long orderId, Long orderDetailId, Long productId, Integer itemsNumber) {
        
        OrderDetail orderDetail = orderDetailRepository.updateOrderDetail(orderDetailId, productId, itemsNumber, new Date()).orElse(null);

        return new ResponseOrder(orderRepository.updateOrder(orderId, orderDetailId).orElse(null));
    }
    
}
