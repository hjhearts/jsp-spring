package work04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

//@WebServlet("/cookieGetTest")
public class GetCookieValue extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Cookie[] cookie = request.getCookies();
        for (int i = 0; i < cookie.length; i++) {
            if(cookie[i].getName().equals("cookieTest")){
                out.println("<h2>Cookie Value :" + URLDecoder.decode(cookie[i].getValue(), "utf-8"));
            }
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() throws ServletException {

    }
}
