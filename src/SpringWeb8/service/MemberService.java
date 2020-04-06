package SpringWeb8.service;

import SpringWeb8.vo.MemberVO;

import java.util.List;

public interface MemberService {
    List<MemberVO> listMembers();
    int addMember(MemberVO vo);
    int removeMember(String id);
}
