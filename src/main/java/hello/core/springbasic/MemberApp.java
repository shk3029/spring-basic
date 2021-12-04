package hello.core.springbasic;

import hello.core.springbasic.member.Grade;
import hello.core.springbasic.member.Member;
import hello.core.springbasic.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
/*
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new = " + member.getName());
        System.out.println("find = " + findMember.getName());
    }
}
