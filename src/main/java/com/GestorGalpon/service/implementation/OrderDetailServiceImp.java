package com.GestorGalpon.service.implementation;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestorGalpon.models.orderdetails.OrderDetail;
import com.GestorGalpon.models.orderdetails.dto.RequestOrderDetail;
import com.GestorGalpon.models.orderdetails.dto.ResponseOrderDetail;
import com.GestorGalpon.repository.OrderDetailRepository;
import com.GestorGalpon.service.abstraction.OrderDetailService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional
public class OrderDetailServiceImp implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;



    @Override
    public ResponseOrderDetail createOrderDetail(RequestOrderDetail orderDetail) {
         return new ResponseOrderDetail(orderDetailRepository.save(new OrderDetail(orderDetail)));
    }

    @Override
    public ResponseOrderDetail findById(Long id) {
        
        return new ResponseOrderDetail(orderDetailRepository.findById(id).orElse(null));
    }

    @Override
    public ResponseOrderDetail deleteOrderDetailById(Long orderDetailId) {
        orderDetailRepository.deleteById(orderDetailId);
        return null;
    }

    @Override
    public ResponseOrderDetail updateOrderDetail(Long orderDetailId, Integer itemsNumber) {

        return  new ResponseOrderDetail(orderDetailRepository.updateOrderDetail(orderDetailId, itemsNumber, new Date()).orElse(null));
    }

    @Override
    public ResponseOrderDetail updateOrderDetailIsPresent(Long orderDetailId, Boolean isPresent) {
       if(isPresent==true){
            return new ResponseOrderDetail(orderDetailRepository.updateIsPresent(orderDetailId,false).orElse(null));
        }else{
            return new ResponseOrderDetail(orderDetailRepository.updateIsPresent(orderDetailId,true).orElse(null));
        }
    }

    
}