package hello.core;

import hello.core.memeber.Grade;
import hello.core.memeber.Member;
import hello.core.memeber.MemberService;
import hello.core.memeber.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//주문과 할인 정책 실행
public class OrderApp {

    public static void main(String[] args) {
     //   AppConfig appConfig = new AppConfig();
     //   MemberService memberService = appConfig.memberService();
     //   OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        final MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        final OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        final Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        final Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
