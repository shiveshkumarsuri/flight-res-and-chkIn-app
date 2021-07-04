package com.shivesh.flightreservation.services;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shivesh.flightreservation.entities.ChargeRequest;
import com.stripe.Stripe;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Service
public class StripeService {
 
    @Value("${STRIPE_SECRET_KEY}")
    private String secretKey;
     
    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }
    public Charge charge(ChargeRequest chargeRequest) 
      throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());
        return Charge.create(chargeParams);
    }
}
