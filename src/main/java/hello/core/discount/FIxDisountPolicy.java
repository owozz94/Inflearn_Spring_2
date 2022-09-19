package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FIxDisountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000;

    public FIxDisountPolicy() {
    }

    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? this.discountFixAmount : 0;
    }
}
