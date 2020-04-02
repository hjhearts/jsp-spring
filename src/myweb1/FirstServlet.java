package myweb1;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//@WebServlet(urlPatterns = "/ae")
public class FirstServlet extends HttpServlet {
    @Override
    public void init(){
        System.out.println("init() 메서드 호출");
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        System.out.println("doGet() 메서드 호출");
        PrintWriter out = res.getWriter();
        req.setCharacterEncoding("UTF-8");
        out.println("Hello Servlet");
    }
    @Override
    public void destroy(){
        System.out.println("destroy() 메서드 호출");
    }
}
