package myweb1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/test5")
public class TestServlet05 extends HttpServlet {
    public void init(){
        System.out.println("init()메서드 호출");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String[] subject = request.getParameterValues("subject");
        PrintWriter out = response.getWriter();
        String data = "<html>";
        data += "<body>";
        data += "아이디 : " + id;
        data += "<br>";
        data += "패스워드 : " + password;
        data += "<br>";
        data += "과목 : ";
        for(String str : subject){
            data += str + " ";
        }
        data += "</body>";
        data += "</html>";
        out.print(data);
    }
    public void destroy(){
        System.out.println("destroy()메서드 호출");
    }
}
