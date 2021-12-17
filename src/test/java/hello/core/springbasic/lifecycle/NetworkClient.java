package hello.core.springbasic.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient /* implements InitializingBean, DisposableBean */{

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call" + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }

    // 최신 스프링에서 가장 권장하는 방법
    // 스프링 종속적인 기술이 아닌 JSR-250 자바표준이다
    // 스프링이 아닌 다른 컨테이너에서도 동작함
    // 유일한 단점 : 외부 라이브러리에는 적용하지 못함
    // (외부 라이브러리에는 @Bean의 init, destroy 을 사용하자)

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }

/*
    // 스프링을 이용한 초기화, 소멸 인터페이스는 사용하지 않는다
    // 의존관계 주입이 끝나면 수행해준다
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("NetworkClient.afterProperties");
        connect();
        call("초기화 연결 메시지");
    }

    // 종료가 될 때 수행해준다
    @Override
    public void destroy() throws Exception {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }*/
}
