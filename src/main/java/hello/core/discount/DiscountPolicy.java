package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    int discount(Member var1, int var2);
}
