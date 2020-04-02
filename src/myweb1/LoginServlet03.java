package myweb1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//@WebServlet("/login4")
public class LoginServlet03 extends HttpServlet {
    public void init(){
        System.out.println("init()");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String user_id = request.getParameter("id");
        PrintWriter out = response.getWriter();
        if(user_id != null && (user_id.length()) != 0) {
            if (user_id.equalsIgnoreCase("admin")) {
                out.print("<html>");
                out.print("<body>");
                out.print("Welcome Admin");
                out.print("</body>");
                out.print("</html>");
            }else{
                out.print("<html>");
                out.print("<body>");
                out.print("Welcome " + user_id);
                out.print("</body>");
                out.print("</html>");
            }
        }else{
            out.print("<html>");
            out.print("<body>");
            out.print("Input your ID!!<br>");
            out.print("<a href='http://localhost:8080/myweb1/form_test_04.html'>");
            out.print("Back To Login</a>");
            out.print("</body>");
            out.print("</html>");
        }
    }
    public void destroy(){
        System.out.println("destroy()");
    }
}
