package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//배우가 직접 담당배우를 설정하는 것과 같음
@Component
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    @Autowired //마치 (ac.getBean(MemberRepository.class) 랑 같음
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {
        this.memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return this.memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
