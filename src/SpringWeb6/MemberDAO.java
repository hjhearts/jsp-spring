package SpringWeb6;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class MemberDAO {
    private static SqlSessionFactory sqlMapper = null;
    public static SqlSessionFactory getInstance(){
        if(sqlMapper == null){
            try{
                String resource = "Mybatis/SqlMapConfig.xml";
                Reader reader = Resources.getResourceAsReader(resource);
                sqlMapper = new SqlSessionFactoryBuilder().build(reader);
                reader.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return sqlMapper;
    }
    public List<MemberVO> selectAllMemberList(){
        sqlMapper = getInstance();
        SqlSession sqlSession = sqlMapper.openSession();
        return sqlSession.selectList("mapper.member.selectAllMemberList");
    }
}
