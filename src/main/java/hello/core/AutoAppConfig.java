package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",
        // @Configuration이 붙은 AppConfig.class는 제외하고 주입
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) // @Component가 붙은 클래스들을 스캔해서 스프링 빈으로 등록
public class AutoAppConfig {

    // 수동 빈 등록이 자동등록 빈의 이름과 같을 경우
    /*@Bean(name = "MemoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/
}
