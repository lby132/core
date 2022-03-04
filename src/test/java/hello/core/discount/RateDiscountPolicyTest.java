package hello.core.discount;

import hello.core.memeber.Grade;
import hello.core.memeber.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RateDiscountPolicyTest {

    private DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        final Member member = new Member(1L, "memberA", Grade.VIP);
        final int discount = discountPolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 10% 할인이 적용되지 않아야 한다.")
    void vip_x() {
        final Member member = new Member(1L, "memberA", Grade.BASIC);
        final int discount = discountPolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(0);
    }
}
