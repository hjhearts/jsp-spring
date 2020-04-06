package SpringWeb8.dao;

import SpringWeb8.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class MemberDAOImpl implements MemberDAO{
    private SqlSession sqlSession;
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<MemberVO> selectAllMemberList() {
        return sqlSession.selectList("mapper.member.selectAllMemberList");
    }

    @Override
    public int insertMember(MemberVO vo) {
        return sqlSession.insert("mapper.member.insertMember", vo);
    }

    @Override
    public int deleteMember(String id) {
        return sqlSession.delete("mapper.member.deleteMember", id);
    }
}
