package hello.core.member;
//배우가 직접 담당배우를 설정하는 것과 같음
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        //생성자 주입ㄴ
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {
        this.memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return this.memberRepository.findById(memberId);
    }
}
