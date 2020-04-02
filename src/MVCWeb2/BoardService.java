package MVCWeb2;

import java.util.*;
public class BoardService {
    BoardDAO boardDAO;
    public BoardService(){
        boardDAO = new BoardDAO();
    }

    public Map listArticles(Map<String, Integer> pagingMap){
        Map articleMap = new HashMap();
        List<ArticleVO> articleList = boardDAO.selectAllArticles(pagingMap);
        int totArticles = boardDAO.totArticles();
        articleMap.put("articleList", articleList);
        articleMap.put("totalArticles", totArticles);
        return articleMap;
    }

    public int addArticle(ArticleVO articleVO){
        return boardDAO.insertNewArticle(articleVO);
    }

    public ArticleVO viewArticle(int articleNO){
        return boardDAO.selectArticle(articleNO);
    }

    public void modArticle(ArticleVO articleVO){
        boardDAO.modArticle(articleVO);
    }

    public List<Integer> delArticle(int articleNO) {
        List<Integer> articleNOList = boardDAO.removedArticles(articleNO);
        boardDAO.deleteArticle(articleNO);
        return articleNOList;
    }
    public void makeTestArticle(){
        boardDAO.insertTestArticle();
    }
}
