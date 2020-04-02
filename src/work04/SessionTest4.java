package work04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/login")
public class SessionTest4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doHandle(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doHandle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        if(session.getAttributeNames() == null){
            System.out.println("Empty Session");
            System.out.println(session.getAttributeNames().toString());
            session.invalidate();
            session = request.getSession(true);
        }
        String user_id = request.getParameter("user_id");
        String user_pwd = request.getParameter("user_pwd");
        System.out.println(user_id + " at line 34");
        System.out.println(session.isNew() + " at line 35");
        if(session.isNew()){
            if(user_id != null){
                session.setAttribute("user_id", user_id);
                out.println("<a href='/login'>로그인 상태 확인</a>");
            }else{
                out.println("<a href='/work04/login2.html'>다시 로그인</a>");
                session.invalidate();
            }
        }else{
            user_id = (String)session.getAttribute("user_id");
            System.out.println(user_id + " at line 45");
            if(user_id != null && user_id.length() != 0){
                out.println("Hello " + user_id + "!");
            }else{
                out.println("<a href='/work04/login2.html'>다시 로그인</a>");
                session.invalidate();
            }
        }
    }
}
