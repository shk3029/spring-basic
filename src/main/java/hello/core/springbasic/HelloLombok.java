package hello.core.springbasic;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok lombok = new HelloLombok();
        lombok.setAge(12);
    }

}
