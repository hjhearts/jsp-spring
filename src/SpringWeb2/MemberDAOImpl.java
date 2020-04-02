package SpringWeb2;

public class MemberDAOImpl implements MemberDAO {
    @Override
    public void listMembers() {
        System.out.println("listMembers 호출");
        System.out.println("회원 정보 조회");
    }
}
