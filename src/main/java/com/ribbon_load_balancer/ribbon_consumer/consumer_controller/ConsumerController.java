package com.ribbon_load_balancer.ribbon_consumer.consumer_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
        /***Ribbon_Consumer作为服务消费者使用了Eureka_Client作为服务提供者所提供的服务**/
        //return restTemplate.getForEntity("http://HELLO-SERVICE-CLUSTER/hello", String.class).getBody();
        return restTemplate.getForObject("http://HELLO-SERVICE-CLUSTER/hello", String.class); //getForObject()是对getForEntity()的进一步封装
    }
}
