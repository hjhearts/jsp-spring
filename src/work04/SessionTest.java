package work04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
//@WebServlet("/sessionTest")
public class SessionTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        out.println("Session id : " + session.getId() + "<br>");
        out.println("Session creationTime : " + session.getCreationTime() + "<br>");
        out.println("Session AccessedTime : " + new Date(session.getLastAccessedTime()) + "<br>");
        out.println("Session IntervalTime : " + session.getMaxInactiveInterval());
        if(session.isNew()){
            out.println("<br>New Session Create!");
        }
    }
}
