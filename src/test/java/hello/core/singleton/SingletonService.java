package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    //static을 쓰면 클래스 레벨에만 올라가기 때문에 하나만 존재하게 됨

    public static SingletonService getInstance() {
        //Jvm을 실행할 때 자기자신을 실행해서 instance라는 변수에 참조로 넣어 놓는다

        return instance;
    }

    private SingletonService() {
        //외부에서 선언 불가능
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
