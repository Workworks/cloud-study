package com.kfaino.repository;

import com.kfaino.entity.Payment;
import com.kfaino.ProviderMain8081;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProviderMain8081.class)
public class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository repository;

    @Test
    public void testAdd() {
        Payment payment = new Payment();
        payment.setId(2l);
        payment.setSerial("123123");
        Payment result = repository.save(payment);
        Assert.assertNotNull(result);
    }
}