package SpringWeb5.service;

import SpringWeb5.dao.MemberDAO;
import SpringWeb5.vo.MemberVO;

import java.util.List;

public interface MemberService {
    public List listMembers();
    public void addMember(MemberVO memberVO);
}
