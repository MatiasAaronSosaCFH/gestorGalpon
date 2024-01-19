package com.GestorGalpon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestorGalpon.models.order.dto.RequestOrder;
import com.GestorGalpon.models.order.dto.ResponseOrder;
import com.GestorGalpon.service.implementation.OrderServiceImp;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RequestMapping("/order")
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderServiceImp orderServiceImp;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllAvailable() {

        List<ResponseOrder> orders = orderServiceImp.findAllOrderAvailable();

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findByName(@PathVariable @NotBlank Long id) {
        ResponseOrder order = orderServiceImp.findById(id);
        if(order==null) {return new ResponseEntity<>(order, HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(orderServiceImp.findById(id), HttpStatus.OK);

        }
       
    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody @Valid RequestOrder order) {
        return new ResponseEntity<>(orderServiceImp.createOrder(order), HttpStatus.OK);
    }

    @PutMapping("/mod-order")
    public ResponseEntity<?> updateOrder(@RequestParam @NotBlank Long orderId,
                                         @RequestParam @NotBlank Long orderDetailId,
                                         @RequestParam @NotBlank Long productId,
                                         @RequestParam @NotBlank Integer itemsNumber) {
        ResponseOrder order = orderServiceImp.updateOrder(orderId, orderDetailId, productId, itemsNumber);
        if(order == null) {return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);}
                                            

        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    
        
    }
    
    
    

