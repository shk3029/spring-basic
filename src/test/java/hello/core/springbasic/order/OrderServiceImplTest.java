package hello.core.springbasic.order;

import hello.core.springbasic.discount.FixDiscountPolicy;
import hello.core.springbasic.member.Grade;
import hello.core.springbasic.member.Member;
import hello.core.springbasic.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

    @Test
    void creatOrder() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository, new FixDiscountPolicy());
        Order itemA = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(itemA.getDiscountPrice()).isEqualTo(1000);
    }

}