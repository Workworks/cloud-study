package com.kfaino.controller;

import com.kfaino.entity.CommonResult;
import com.kfaino.entity.Payment;
import com.kfaino.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        Payment result = paymentService.save(payment);
        log.info("插入结果"+result);
        if(!StringUtils.isEmpty(result)){
            return new CommonResult(200,"插入数据库成功,serverPort"+serverPort,result);
        }else {
            return new CommonResult(400,"插入数据库失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        Payment result = paymentService.getOne(id);
        log.info("根据id查询结果"+result);
        if(!StringUtils.isEmpty(result)){
            return new CommonResult(200,"获取数据库成功",result);
        }else {
            return new CommonResult(400,"获取数据库失败");
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("******element:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

}
