package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan (
        basePackages= "hello.core.member",
        //hello.core.member 밑으로만 스캔함 나머지는 등록이 안됨
        basePackageClasses = AutoAppConfig.class,
        //지정하지 않으면 componentscan이 붙은 패키지부터 다 스캔함
        excludeFilters = @ComponentScan.Filter (type= FilterType.ANNOTATION, classes = Configuration.class)
)
//component붙은 클래스를 다 찾아서 빈으로 등록시킴
public class AutoAppConfig {

    @Bean(name="memoryMemberRepository")
        //이렇게 수동으로 빈 등록을 해주면 component 어노테이션을 달아준 memoryMemberRepository랑 충돌나야되는데
        //통과한다 ! -> why? 자동이랑 수동 중에 수동이 먼저 우선이 돼서 통과하게 됨
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
