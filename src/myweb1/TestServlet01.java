package myweb1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/test1")
public class TestServlet01 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    public void init(){
        System.out.println("init() 메서드 호출됨");
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException {
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\tThis is Servlet Response\n" +
                "Servlet 의 doGet() 메서드 호출됨\n" +
                "</body>\n" +
                "</html>");
        System.out.println("doGet() 메서드 호출됨");
    }
    @Override
    public void destroy(){
        System.out.println("destroy() 메서드 호출됨");
    }
}
