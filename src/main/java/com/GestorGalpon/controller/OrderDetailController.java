package com.GestorGalpon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GestorGalpon.models.orderdetails.dto.RequestOrderDetail;
import com.GestorGalpon.models.orderdetails.dto.ResponseOrderDetail;
import com.GestorGalpon.service.implementation.OrderDetailServiceImp;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RequestMapping("/order_detail")
@RestController
@RequiredArgsConstructor
public class OrderDetailController {

    private final OrderDetailServiceImp orderDetailServiceImp;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long orderDetailId) {

        ResponseOrderDetail orderDetail = orderDetailServiceImp.findById(orderDetailId);
        if(orderDetail == null){return new ResponseEntity<>("orderDetail not found",HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(orderDetail,HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> createOrderDetail(@RequestBody @Valid RequestOrderDetail orderDetail) {
        
        return new ResponseEntity<>(orderDetailServiceImp.createOrderDetail(orderDetail),HttpStatus.OK);
    }

    @PutMapping("/mod-od/{id}")
    public ResponseEntity<?> updateOrderDetail(@RequestParam @NotBlank Long orderDetailId,
                                               @RequestParam @NotBlank Integer itemsNumber) {
        ResponseOrderDetail orderDetail = orderDetailServiceImp.updateOrderDetail(orderDetailId, itemsNumber);
        if(orderDetail == null){return new ResponseEntity<>("orderDetail not found", HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(orderDetail, HttpStatus.OK);
    }
    @PutMapping("/mod_od_ispresent/{id}")
    public ResponseEntity<?> putMethodName(@RequestParam @NotBlank Long orderDetailId,
                                       @RequestParam @NotBlank Boolean isPresent) {
        ResponseOrderDetail orderDetail = orderDetailServiceImp.updateOrderDetailIsPresent(orderDetailId, isPresent);
        if(orderDetail == null) {return new ResponseEntity<>("orderDetail not found", HttpStatus.NOT_FOUND);}
        
        return new ResponseEntity<>(orderDetail, HttpStatus.OK);
    }
    
}
