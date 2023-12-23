package com.GestorGalpon.service.abstraction;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.GestorGalpon.models.orderdetails.OrderDetail;
import com.GestorGalpon.models.orderdetails.dto.RequestOrderDetail;
import com.GestorGalpon.models.orderdetails.dto.ResponseOrderDetail;
import com.GestorGalpon.models.product.dto.RequestProduct;

@Service
public interface OrderDetailService {

    ResponseOrderDetail createOrderDetail(RequestOrderDetail orderDetail);
    ResponseOrderDetail findById(Long id);
    List<ResponseOrderDetail> findOrderDetailsByCreate(Date createAt);
    ResponseOrderDetail deleteProductById(Long id);
    ResponseOrderDetail insertProduct(RequestProduct product);
    ResponseOrderDetail subTotal(RequestOrderDetail orderDetail);

    List<OrderDetail> findAllOrderDetails();


}
