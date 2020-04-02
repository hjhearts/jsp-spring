package work07;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
//@WebServlet("/setSession")
public class SessionTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        session.setAttribute("name", "한주성");
        out.println("<html><body>");
        out.println("<h2>세션에 이름을 바인딩 했습니다.</h2>");
        out.println("<a href='/work07/session1.jsp'>결과확인</a>");
    }
}
