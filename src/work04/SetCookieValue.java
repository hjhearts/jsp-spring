package work04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
//@WebServlet("/cookieSetTest")
public class SetCookieValue extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Date d = new Date();
        Cookie cookie = new Cookie("cookieTest", URLEncoder.encode("JSP 프로그래밍", "utf-8"));
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
        out.println("현재시간 : " + d);
        out.println("문자열을 Cookie 에 저장함");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() throws ServletException {

    }
}
