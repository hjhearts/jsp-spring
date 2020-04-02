package SpringWeb2;

public class MemberServiceImpl implements MemberService{
    private MemberDAO memberDAO;
    public void setMemberDAO(MemberDAO memberDAO){
        this.memberDAO = memberDAO;
    }

    @Override
    public void lisMembers() {
        memberDAO.listMembers();
    }
}
