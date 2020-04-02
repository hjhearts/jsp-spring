package myweb1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

//@WebServlet("/test4")
public class TestServlet04 extends HttpServlet {
    public void init(){
        System.out.println("init()메서드 호출");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        Enumeration<String> enu = request.getParameterNames();
        while(enu.hasMoreElements()) {
            String name = enu.nextElement();
            String[] values = request.getParameterValues(name);
            for(String value : values){
                System.out.println("name : " + name + " value : " + value);
            }
        }
    }
    public void destroy(){
        System.out.println("destroy()메서드 호출");
    }
}
