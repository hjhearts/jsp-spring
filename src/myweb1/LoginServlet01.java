package myweb1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//@WebServlet("/login2")
public class LoginServlet01 extends HttpServlet {
    public void init(){
        System.out.println("init()");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String address= request.getParameter("address");
        String[] subjects = request.getParameterValues("subject");
        PrintWriter out = response.getWriter();
        String data = "<html>";
        data += "<body>";
        data += "Id : " + id;
        data += "<br>";
        data += "Password : " + password;
        data += "<br>";
        data += "Subject : ";
        for(String str : subjects){
            data += str + " ";
        }
        data += "<br>";
        data += "Address : " + address;
        data += "</body></html>";
        out.print(data);
    }
    public void destroy(){
        System.out.println("destroy()");
    }
}
