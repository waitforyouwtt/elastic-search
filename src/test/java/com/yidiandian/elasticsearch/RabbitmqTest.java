package com.yidiandian.elasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/6/20 17:07
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class RabbitmqTest extends ElasticSearchApplicationTests{
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("hello","世界就算一个巨大的夹娃娃机，隔着玻璃，我只想得到你");
    }

}
