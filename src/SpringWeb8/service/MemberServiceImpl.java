package SpringWeb8.service;

import SpringWeb8.dao.MemberDAO;
import SpringWeb8.vo.MemberVO;

import java.util.List;

public class MemberServiceImpl implements MemberService{
    private MemberDAO memberDAO;
    public void setMemberDAO(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public List<MemberVO> listMembers() {
        return memberDAO.selectAllMemberList();
    }

    @Override
    public int addMember(MemberVO vo) {
        return memberDAO.insertMember(vo);
    }

    @Override
    public int removeMember(String id) {
        return memberDAO.deleteMember(id);
    }
}
