package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;


class StatefulServiceTest {

    @Test
    void statefulServiceTestSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A사용자 10000원 주문
        statefulService1.order("userA", 10000);

        //ThreadB : B사용자 20000원 주문
        statefulService2.order("userB", 20000);

        //ThreadA : 사용자 A가 주문 금액 조회
        int price = statefulService1.getPrice();

        //같은 인스턴스를 쓰기 떄문에 마지막값이 나옴
        System.out.println("price: " + price);

        Assertions.assertEquals(statefulService1.getPrice(), 20000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}