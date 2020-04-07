package SpringWeb9.account;

import org.apache.ibatis.session.SqlSession;

public class AccountDAO {
    private SqlSession sqlSession;
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void updateBalance1() {
        sqlSession.update("mapper.account.updateBalance1");
    }

    public void updateBalance2() {
        sqlSession.update("mapper.account.updateBalance2");
    }
}
