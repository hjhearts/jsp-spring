package myweb1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/gugudan")
public class MultipleServlet extends HttpServlet {
    public void init(){
        System.out.println("init");
    };
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<body>");
        int dan = Integer.parseInt(request.getParameter("num"));
        for (int i = 2; i < 10; i++) {
            out.print(dan + " X " + i + " = " + dan*i);
            out.print("<br>");
        }
        out.print("</body>");
        out.print("</html>");
    }
    public void destroy(){
        System.out.println("destroy");
    };

}
