package myweb1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/test3")
public class TestServlet03 extends HttpServlet {
    public void init(){
        System.out.println("init()메서드 호출");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String[] subject = request.getParameterValues("subject");
        System.out.println("id : " + id);
        System.out.println("password : " + password);
        for(String str : subject){
            System.out.println("subject : " + str);
        }
    }
    public void destroy(){
        System.out.println("destroy()메서드 호출");
    }
}
