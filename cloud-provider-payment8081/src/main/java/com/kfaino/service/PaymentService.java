package com.kfaino.service;

import com.kfaino.entity.Payment;


public interface PaymentService {
    public Payment save(Payment payment);

    public Payment getOne(Long id);
}
