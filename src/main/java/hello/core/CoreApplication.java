package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);

		// 비지니스 설계 보고 역할과 구현 생각
		//도메인 -> 기획자도 알 수있는
		// 도메인 에서 클래스 다이어그램 구현
		// 클래스다이어그램에서 서버가 실제로 사용하는 클래스를 모른다.
		// 객체 다이어그램 -> 클라이언트가 실제로 사용하는 클래스 정의 (new 한 인스턴스들 끼리의 관계)


	}

}
