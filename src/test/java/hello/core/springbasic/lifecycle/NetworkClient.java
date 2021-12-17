package hello.core.springbasic.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

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
    }
}
