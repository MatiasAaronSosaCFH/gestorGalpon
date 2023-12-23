package com.GestorGalpon.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestorGalpon.models.orderdetails.OrderDetail;
import com.GestorGalpon.models.orderdetails.dto.RequestOrderDetail;
import com.GestorGalpon.models.orderdetails.dto.ResponseOrderDetail;
import com.GestorGalpon.models.product.dto.RequestProduct;
import com.GestorGalpon.repository.OrderDetailRepository;
import com.GestorGalpon.service.abstraction.OrderDetailService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional
public class OrderDetailServiceImp implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> findAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    @Override
    public ResponseOrderDetail createOrderDetail(RequestOrderDetail orderDetail) {
         return new ResponseOrderDetail(orderDetailRepository.save(new OrderDetail(orderDetail)));
    }

    @Override
    public ResponseOrderDetail findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<ResponseOrderDetail> findOrderDetailsByCreate(Date createAt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOrderDetailsByCreate'");
    }

    @Override
    public ResponseOrderDetail deleteProductById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProductById'");
    }

    @Override
    public ResponseOrderDetail insertProduct(RequestProduct product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertProduct'");
    }

    @Override
    public ResponseOrderDetail subTotal(RequestOrderDetail orderDetail) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subTotal'");
    }

  
    



}
