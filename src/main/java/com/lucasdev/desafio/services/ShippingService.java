package com.lucasdev.desafio.services;

import com.lucasdev.desafio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {
        double valueOrder = order.getBasic();
        return valueOrder < 100 ? 20.00 : valueOrder < 200 ? 12.00 : 0.0;
    }
}
