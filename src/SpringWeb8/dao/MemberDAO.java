package SpringWeb8.dao;

import SpringWeb8.vo.MemberVO;
import java.util.*;
public interface MemberDAO {
    List<MemberVO> selectAllMemberList();
    int insertMember(MemberVO vo);
    int deleteMember(String id);
}
