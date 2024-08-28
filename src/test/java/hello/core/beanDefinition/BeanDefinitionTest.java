package hello.core.beanDefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

//    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    GenericApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
    //xml로 선언하면 명확한 bean class정보가 나온다.
    //자바 코드로 빈을 설정하는 건 팩토리 메서드를 쓴다. 외부에서 메서드를 호출해서 생성되는 방식 -> class 정보가 널로 나옴 factoryBeanName에 빈 정보가 들어가 있음

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        String[] beanDefinitionNames= ac.getBeanDefinitionNames();

        for(String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = "+beanDefinitionName + " beanDefinition ="+ beanDefinition);
            }
        }
    }
}
