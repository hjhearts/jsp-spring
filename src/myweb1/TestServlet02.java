package myweb1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//@WebServlet("/test2")
public class TestServlet02 extends HttpServlet {
    public void init(){
        System.out.println("Servlet Loaded on Thread");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String user_id = request.getParameter("id");
        String user_password = request.getParameter("password");
        System.out.println("ID : " + user_id);
        System.out.println("PASSWORD : " + user_password);
    }
    public void destroy(){
        System.out.println();
    }
}
