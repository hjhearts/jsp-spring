package SpringWeb5.dao;



import SpringWeb5.vo.MemberVO;

import java.util.List;

public interface MemberDAO {
    public List selectAllMembers();
    public int addMember(MemberVO memberVO);
}
