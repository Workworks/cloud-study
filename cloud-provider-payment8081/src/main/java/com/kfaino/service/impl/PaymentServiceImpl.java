package com.kfaino.service.impl;

import com.kfaino.entity.Payment;
import com.kfaino.repository.PaymentRepository;
import com.kfaino.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service

public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentRepository repository;


    @Override
    public Payment save(Payment payment) {
        return repository.save(payment);
    }

    @Override
    @Transactional
    public Payment getOne(Long id) {
        return repository.getOne(id);
    }
}
