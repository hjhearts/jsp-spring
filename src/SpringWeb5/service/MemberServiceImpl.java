package SpringWeb5.service;

import SpringWeb5.dao.MemberDAO;
import SpringWeb5.vo.MemberVO;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class MemberServiceImpl implements MemberService{
    private MemberDAO memberDAO;
    public void setMemberDAO(MemberDAO memberDAO){
        this.memberDAO = memberDAO;
    }
    @Override
    public List listMembers() throws DataAccessException {
        List membersList = memberDAO.selectAllMembers();
        return membersList;
    }

    public void addMember(MemberVO vo){
        int result = memberDAO.addMember(vo);
        System.out.println("추가작업 완료 Status : " + result);
    }
}
