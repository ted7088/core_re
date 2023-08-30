package com.example.hello.core_re.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //thread a : a 사용자가 만원 주문
        int userAprice = statefulService1.order("userA", 10000);
        //thread b : b 사용자가 2만원 주문
        int userBprice = statefulService2.order("userB", 20000);

        //thread a : 사용자a 주문 금액 조회
//        int price = statefulService1.getPrice();

        System.out.println("price = " + userAprice);

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}