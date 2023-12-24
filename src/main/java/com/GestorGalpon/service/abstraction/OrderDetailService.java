package com.GestorGalpon.service.abstraction;


import org.springframework.stereotype.Service;

import com.GestorGalpon.models.orderdetails.dto.RequestOrderDetail;
import com.GestorGalpon.models.orderdetails.dto.ResponseOrderDetail;

@Service
public interface OrderDetailService {

    ResponseOrderDetail createOrderDetail(RequestOrderDetail orderDetail);
    ResponseOrderDetail findById(Long id);
    ResponseOrderDetail deleteOrderDetailById(Long idOrderDetail);
    ResponseOrderDetail updateOrderDetail(Long orderDetailId, Integer itemsNumber);
    ResponseOrderDetail updateOrderDetailIsPresent(RequestOrderDetail orderDetail);


}
