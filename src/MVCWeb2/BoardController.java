package MVCWeb2;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.io.*;
//@WebServlet("/board/*")
public class BoardController extends HttpServlet {
    private static String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";
    BoardService boardService;
    ArticleVO articleVO;

    @Override
    public void init() {
        boardService = new BoardService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doHandle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doHandle(req, resp);
    }

    protected void doHandle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getPathInfo();
        String nextPage;
        System.out.println("action : " + action);
        List<ArticleVO> articleList = new ArrayList<>();
        if(action == null){
            String _section = request.getParameter("section");
            String _pageNum = request.getParameter("pageNum");
            int section = Integer.parseInt((_section==null)? "1" : _section);
            int pageNum = Integer.parseInt((_pageNum==null)? "1" : _pageNum);
            Map<String, Integer> pagingMap = new HashMap<>();
            pagingMap.put("section", section);
            pagingMap.put("pageNum", pageNum);
            Map articleMap = boardService.listArticles(pagingMap);
            articleList = (List)articleMap.get("articleList");
            articleMap.put("section", section);
            articleMap.put("pageNum", pageNum);
            request.setAttribute("articleMap", articleMap);
            nextPage = "/work15/listArticles.jsp";
        }
        else if (action.equals("/listArticles.do")) {
            String _section = request.getParameter("section");
            String _pageNum = request.getParameter("pageNum");
            int section = Integer.parseInt((_section==null)? "1" : _section);
            int pageNum = Integer.parseInt((_pageNum==null)? "1" : _pageNum);
            Map<String, Integer> pagingMap = new HashMap<>();
            pagingMap.put("section", section);
            pagingMap.put("pageNum", pageNum);
            Map articleMap = boardService.listArticles(pagingMap);
            articleMap.put("section", section);
            articleMap.put("pageNum", pageNum);
            request.setAttribute("articleMap", articleMap);
            nextPage = "/work15/listArticles.jsp";
        }else if(action.equals("/articleForm.do")) {
            nextPage = "/work15/articleForm.jsp";
        }else if(action.equals("/addArticle.do")){
            Map<String, String> articleMap = upload(request, response);
            String title = articleMap.get("title");
            String content = articleMap.get("content");
            String imageFileName = articleMap.get("imageFileName");

            articleVO = new ArticleVO();
            articleVO.setParentNO(0);
            articleVO.setId("hong");
            articleVO.setTitle(title);
            articleVO.setContent(content);
            articleVO.setImageFileName(imageFileName);

            if(imageFileName != null && imageFileName.length() > 0) {
                File tmpFile = new File(ARTICLE_IMAGE_REPO + "\\temp\\" + imageFileName);
                int articleNO = boardService.addArticle(articleVO);
                File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);
                FileUtils.moveFileToDirectory(tmpFile, destDir, true);
            }

            nextPage = "/board/listArticles.do";
        }else if(action.equals("/viewArticle.do")){
            int articleNO = Integer.parseInt(request.getParameter("articleNO"));
            articleVO = boardService.viewArticle(articleNO);
            request.setAttribute("article", articleVO);
            nextPage = "/work15/viewArticle.jsp";
        }else if(action.equals("/modArticle.do")){
            int articleNO = Integer.parseInt(request.getParameter("articleNO"));
            String title = request.getParameter("title") + "(수정됨)";
            String content = request.getParameter("content");
            articleVO = new ArticleVO();
            articleVO.setArticleNO(articleNO);
            articleVO.setTitle(title);
            articleVO.setContent(content);
            boardService.modArticle(articleVO);
            nextPage = "/board/listArticles.do";
        }else if(action.equals("/delArticle.do")){
            int articleNO = Integer.parseInt(request.getParameter("articleNO"));
            List<Integer> articleNOList = boardService.delArticle(articleNO);
            for(int _articleNO : articleNOList){
                File imgDir = new File(ARTICLE_IMAGE_REPO + "\\" + _articleNO);
                if(imgDir.exists()){
                    FileUtils.deleteDirectory(imgDir);
                }
            }
            nextPage = "/board/listArticles.do";
        }else if(action.equals("/replyArticleForm.do")){
            nextPage = "/work15/replyArticleForm.jsp";
        }else if(action.equals("/replyArticle.do")){
            Map<String, String> articleMap = upload(request, response);
            String title = articleMap.get("title");
            String content = articleMap.get("content");
            String imageFileName = articleMap.get("imageFileName");
            int parentNO = Integer.parseInt(articleMap.get("parentNO"));
            articleVO = new ArticleVO();
            articleVO.setParentNO(parentNO);
            articleVO.setId("hong");
            articleVO.setTitle(title);
            articleVO.setContent(content);
            articleVO.setImageFileName(imageFileName);
            int articleNO = boardService.addArticle(articleVO);
            if(imageFileName != null && imageFileName.length() > 0) {
                File tmpFile = new File(ARTICLE_IMAGE_REPO + "\\temp\\" + imageFileName);
                File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);
                FileUtils.moveFileToDirectory(tmpFile, destDir, true);
            }

            nextPage = "/board/listArticles.do";
        }else if(action.equals("/makeTestArticles.do")){
            boardService.makeTestArticle();
            nextPage = "/board/listArticles.do";
        }else {
            nextPage = "/board/listArticles.do";
        }
        RequestDispatcher dis = request.getRequestDispatcher(nextPage);
        dis.forward(request, response);

    }

    private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String> articleMap = new HashMap<>();
        String encoding = "utf-8";
        File currentDirPath = new File(ARTICLE_IMAGE_REPO);
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(currentDirPath);
        factory.setSizeThreshold(1024 * 1024);
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> items = upload.parseRequest(request);
            for (int i = 0; i < items.size(); i++) {
                FileItem fileItem = items.get(i);
                if (fileItem.isFormField()) {
                    articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
                } else {
                    System.out.println("파라미터 이름 : " + fileItem.getFieldName());
                    System.out.println("파일 이름 : " + fileItem.getName());
                    System.out.println("파일 크기 : " + fileItem.getSize());
                    if (fileItem.getSize() > 0) {
                        int index = fileItem.getName().lastIndexOf("\\");
                        if (index == -1) {
                            index = fileItem.getName().lastIndexOf("/");
                        }
                        String fileName = fileItem.getName().substring(index + 1);
                        articleMap.put(fileItem.getFieldName(), fileName);
                        File uploadFile = new File(currentDirPath + "\\temp\\" + fileName);
                        fileItem.write(uploadFile);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articleMap;
    }
}
