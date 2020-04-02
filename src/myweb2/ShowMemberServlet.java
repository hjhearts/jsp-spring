package myweb2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
//@WebServlet("/show")
public class ShowMemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        boolean isLogin = false;
        HttpSession session = request.getSession();
        if(session != null){
            isLogin = (boolean)session.getAttribute("isLogin");
            if(isLogin){
                String id = (String)session.getAttribute("Login.id");
                String pwd = (String)session.getAttribute("Login.pwd");
                out.println("<html><body>");
                out.println("아이디 : " + id + "<br>");
                out.println("패스워드 : " + pwd + "<br>");
                out.println("</body></html>");
            }else{
                response.sendRedirect("/myweb1/login.html");
            }
        }else{
            response.sendRedirect("/myweb1/login.html");
        }
    }
}
