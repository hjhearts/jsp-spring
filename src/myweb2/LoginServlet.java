package myweb2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/memberLogin")
public class LoginServlet extends HttpServlet {
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
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String user_id = request.getParameter("user_id");
        String user_pwd = request.getParameter("user_pwd");
        MemberDAO dao = new MemberDAO();
        boolean result = dao.isExist(user_id, user_pwd);
        if(result){
            HttpSession session = request.getSession();
            session.setAttribute("isLogin", true);
            session.setAttribute("Login.id", user_id);
            session.setAttribute("Login.pwd", user_pwd);
            out.println("<html><body>");
            out.println("Hello " + user_id + " !!");
            out.println("<a href='/show'>USER INFO</a>");
            out.println("</body></html>");
        }else{
            out.println("<html><body>");
            out.println("<h4>User Info Not Correct</h4>");
            out.println("<a href='/myweb1/login.html'>Re-Login</a>");
            out.println("</body></html>");
        }
    }
}
