package MVCWeb2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

//@WebServlet("/download.do")
public class FileDownloadController extends HttpServlet {
    static String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";
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
            throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String imageFileName = request.getParameter("imageFileName");
        String articleNO = request.getParameter("articleNO");
        OutputStream out = response.getOutputStream();
        String path = ARTICLE_IMAGE_REPO + "\\" + articleNO + "\\" + imageFileName;
        File imageFile = new File(path);
        response.setHeader("Cache-Control", "no-cache");
        response.addHeader("Content-disposition", "attachment;fileName=" + imageFileName);
        FileInputStream in = new FileInputStream(imageFile);
        byte[] buffer = new byte[1024 * 8];
        while(true){
            int count = in.read(buffer);
            if(count == -1)
                break;
            out.write(buffer, 0, count);
        }
        in.close();
        out.close();
    }
}
