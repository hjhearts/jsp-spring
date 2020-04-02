package MVCWeb2;



import oracle.jdbc.proxy.annotation.Pre;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
public class BoardDAO {
    private DataSource dataFactory;
    public BoardDAO(){
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context)ctx.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public List<ArticleVO> selectAllArticles(Map<String, Integer> paging){
        List<ArticleVO> articleList = new ArrayList<>();
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sql;
        try{
            conn = dataFactory.getConnection();
            sql = "select * from(\n" +
                    "             select ROWNUM as recNum,\n" +
                    "                    LVL,\n" +
                    "                    ARTICLENO,\n" +
                    "                    PARENTNO,\n" +
                    "                    title,\n" +
                    "                    CONTENT,\n" +
                    "                    ID,\n" +
                    "                    WRITEDATE\n" +
                    "    from(\n" +
                    "        select LEVEL as LVL,\n" +
                    "               ARTICLENO,\n" +
                    "               PARENTNO,\n" +
                    "               TITLE,\n" +
                    "               CONTENT,\n" +
                    "               ID,\n" +
                    "               WRITEDATE\n" +
                    "        from T_BOARD\n" +
                    "        start with PARENTNO=0\n" +
                    "        connect by prior ARTICLENO=PARENTNO\n" +
                    "        order siblings by ARTICLENO desc\n" +
                    "            )\n" +
                    "                 )\n" +
                    "where recNum between(?-1)*100 + (?-1)*10+1 and (?-1)*100+?*10";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, paging.get("section"));
            pstmt.setInt(2, paging.get("pageNum"));
            pstmt.setInt(3, paging.get("section"));
            pstmt.setInt(4, paging.get("pageNum"));
            rs = pstmt.executeQuery();
            while(rs.next()){
                int level = rs.getInt("lvl");
                int articleNO = rs.getInt("articleNO");
                int parentNO = rs.getInt("parentNO");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String id = rs.getString("id");
                Date writeDate = rs.getDate("writeDate");
                ArticleVO article = new ArticleVO();
                article.setLevel(level);
                article.setArticleNO(articleNO);
                article.setParentNO(parentNO);
                article.setTitle(title);
                article.setContent(content);
                article.setId(id);
                article.setWriteDate(writeDate);
                articleList.add(article);
            }
            conn.commit();
            rs.close();
            pstmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return articleList;
    }

    private int getNewArticleNO(){
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sql;
        int newNum;
        try{
            conn = dataFactory.getConnection();
            sql = "select max(articleNO) from t_board";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return (rs.getInt(1) +1);
            }
            rs.close();
            pstmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public int insertNewArticle(ArticleVO articleVO){
        System.out.println("insertNewArticle 실행");
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sql;
        int articleNO = getNewArticleNO();
        try{
            conn = dataFactory.getConnection();
            sql = "insert into t_board(articleNO, parentNO, title, content, imageFileName, id)" +
             "values (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            int parentNO = articleVO.getParentNO();
            String title = articleVO.getTitle();
            String content = articleVO.getContent();
            String imageFileName = articleVO.getImageFileName();
            String id= articleVO.getId();
            pstmt.setInt(1, articleNO);
            pstmt.setInt(2, parentNO);
            pstmt.setString(3, title);
            pstmt.setString(4, content);
            pstmt.setString(5, imageFileName);
            pstmt.setString(6, id);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return articleNO;
    }

    public ArticleVO selectArticle(int no){
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sql;
        ArticleVO articleVO = null;
        try{
            conn = dataFactory.getConnection();
            sql = "select * from t_board where articleNO=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);
            rs = pstmt.executeQuery();
            articleVO = new ArticleVO();
            while(rs.next()){
                int articleNO = rs.getInt("articleNO");
                int parentNO = rs.getInt("parentNO");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String imageFileName = rs.getString("imageFileName");
                String id = rs.getString("id");
                Date writeDate = rs.getDate("writeDate");
                articleVO.setArticleNO(articleNO);
                articleVO.setParentNO(parentNO);
                articleVO.setTitle(title);
                articleVO.setContent(content);
                articleVO.setImageFileName(imageFileName);
                articleVO.setId(id);
                articleVO.setWriteDate(writeDate);
            }
            rs.close();
            pstmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return articleVO;
    }
    public void modArticle(ArticleVO vo){
        Connection conn;
        PreparedStatement pstmt;
        String sql;
        try{
            conn = dataFactory.getConnection();
            sql = "update t_board set title=?, content=? where articleNO=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getTitle());
            pstmt.setString(2, vo.getContent());
            pstmt.setInt(3, vo.getArticleNO());
            pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteArticle(int articleNO){
        Connection conn;
        PreparedStatement pstmt;
        String sql;
        try{
            conn = dataFactory.getConnection();
            sql = "delete from t_board where articleNO=? or parentNO=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, articleNO);
            pstmt.setInt(2, articleNO);
            pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<Integer> removedArticles(int articleNO){
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sql;
        List<Integer> articleNOList = new ArrayList<>();
        try{
            conn = dataFactory.getConnection();
            sql = "select articleNO from t_board where articleNO=? or parentNO=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, articleNO);
            pstmt.setInt(2, articleNO);
            rs = pstmt.executeQuery();
            while(rs.next()){
                int delArticleNO = rs.getInt("articleNO");
                articleNOList.add(delArticleNO);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return articleNOList;
    }
    public synchronized void insertTestArticle(){
            Connection conn;
            PreparedStatement pstmt;
            String sql;
            int nextNO = getNewArticleNO();
            try {
                conn = dataFactory.getConnection();
                for (int i = 1; i <= 100; i++) {
                    sql = "insert into t_board(articleNO, parentNO, title, content, id) values ((select max(articleNO)+1 from t_board), 0, ?, ?, ?)";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, "TestArticle : " + i);
                    pstmt.setString(2, "TestContent : " + i);
                    pstmt.setString(3, "han");
                    pstmt.executeUpdate();
                    conn.commit();
                    System.out.println("테스트 칼럼 생성중... " + i + "/100");
                }
                conn.close();
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        System.out.println("생성 완료!");
    }
    public int totArticles(){
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sql;
        try{
            conn = dataFactory.getConnection();
            sql = "select count(articleNO) from t_board";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
