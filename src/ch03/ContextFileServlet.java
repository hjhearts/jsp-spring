package ch03;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;
//@WebServlet("/cFile")
public class ContextFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ServletContext context = getServletContext();
        InputStream is = context.getResourceAsStream("/WEB-INF/bin/init.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String menu = null;
        String menu_member = null;
        String menu_order = null;
        String menu_goods = null;
        while((menu = br.readLine()) != null){
            StringTokenizer token = new StringTokenizer(menu, ",");
            menu_member = token.nextToken();
            menu_order = token.nextToken();
            menu_goods = token.nextToken();
        }
        out.println("<html><body>");
        out.println(menu_member + "<br>");
        out.println(menu_order + "<br>");
        out.println(menu_goods + "<br>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() throws ServletException {

    }
}
