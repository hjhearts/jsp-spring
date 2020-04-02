package SpringWeb5.dao;

import SpringWeb5.vo.MemberVO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.*;
import java.util.List;

public class MemberDAOImpl implements MemberDAO{
    private JdbcTemplate jdbcTemplate;
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List selectAllMembers() {
        String query = "select * from t_member order by joinDate DESC";
        List membersList;
        membersList = this.jdbcTemplate.query(query, (rs, rowNum)-> {
            MemberVO memberVO = new MemberVO();
            memberVO.setId(rs.getString("id"));
            memberVO.setPwd(rs.getString("pwd"));
            memberVO.setName(rs.getString("name"));
            memberVO.setEmail(rs.getString("email"));
            memberVO.setJoinDate(rs.getDate("joinDate"));
            return memberVO;
        });
        return membersList;
    }

    @Override
    public int addMember(MemberVO memberVO) throws DataAccessException {
        String id = memberVO.getId();
        String pwd = memberVO.getPwd();
        String name = memberVO.getName();
        String email = memberVO.getEmail();
        String query = "insert into t_member values ('"+id+"', '"+pwd+"', '"+name+"', '"+email+"', default)";
        int result = jdbcTemplate.update(query);
        return result;
    }
}
